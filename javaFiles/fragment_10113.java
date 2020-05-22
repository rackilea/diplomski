package com.android.animation;

import android.app.Activity;
import android.os.Bundle;

public class Main extends Activity 
{

    Animation myView;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myView = new Animation(this);
        setContentView(myView);
    }
}