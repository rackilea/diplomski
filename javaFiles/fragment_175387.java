package com.example.teng.myapplication; 

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout; 
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends android.support.v4.app.Fragment {

View view ;
private TabLayout tabLayout;
private ViewPager viewPager;
private ViewPagerAdapter adapter;


public HomeFragment() { 
    // Required empty public constructor 
} 


@Override 
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment 
    view = inflater.inflate(R.layout.fragment_home, container, false);
    return view ;
} 

@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initComponent();
    }


        // Initialise components and variables
    private void initComponent() {

    adapter = new ViewPagerAdapter(getChildFragmentManager());
    tabLayout = view.findViewById(R.id.tablayout_fragment_home);
    viewPager = view.findViewById(R.id.viewpager_fragment_home);
    adapter.AddFragment(new LatestNews(),"Page1");
    adapter.AddFragment(new PopularProduct(),"Page2");
    adapter.AddFragment(new ThemeActivity(),"Page3");
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
    }


}