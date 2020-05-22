package com.jkhong.app;

import android.app.Activity;
import android.content.res.Configuration;

public class OverridingActivity extends Activity {
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        System.out.println("onConfigurationChanged - subclass override");
    }
}