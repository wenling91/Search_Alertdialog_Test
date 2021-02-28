package com.cooking.edit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cooking.edit.R
import com.cooking.edit.adapters.TablayoutAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(){
    lateinit var myFragment : View
    lateinit var tabLayout : TabLayout
    lateinit var viewPager : ViewPager
    private lateinit var tablayoutAdapter : TablayoutAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        myFragment = inflater.inflate(R.layout.fragment_home, container, false)
        return myFragment
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpViewPager()
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }


    private fun setUpViewPager() {
        // adapter
        tablayoutAdapter = TablayoutAdapter(childFragmentManager)

        // viewPager
        viewPager = view!!.viewPager
        viewPager.adapter = tablayoutAdapter

        // tabLayout
        tabLayout = view!!.ingredients

        // link tabLayout with viewPager
        tabLayout.setupWithViewPager(viewPager)

    }
}
