package com.termite.pockettube;

import com.termite.pockettube.MainActivity.SectionsPagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment implements View.OnClickListener {
 Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Get the view from fragmenttab1.xml
        View view = inflater.inflate(R.layout.fragment1, container, false);
        button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(this);
        return view;
    }
   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }*/
    public void countryOnClick() {
        startActivity(new Intent("com.termite.pockettube.COUNTRY"));
    }
    @Override
public void onClick(View v) {
    switch (v.getId()){
    case R.id.button:
        countryOnClick();
        break;
    }
}
}