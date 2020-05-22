package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentExample extends android.app.Fragment
{

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);

        //Set a linearLayout to add buttons
        LinearLayout linearLayout = new LinearLayout(getActivity());
        // Set the layout full width, full height
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL); //or VERTICAL

        Button button = new Button(getActivity());
        //For buttons visibility, you must set the layout params in order to give some width and height: 
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);

        Button button2 = new Button(getActivity());
                button2.setLayoutParams(params);
        //... and other views

        ViewGroup viewGroup = (ViewGroup) view;

        linearLayout.addView(button);
        linearLayout.addView(button2);

        viewGroup.addView(linearLayout);
    }
}