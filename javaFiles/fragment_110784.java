package com.jkhong.aspect;

import android.app.Activity;
import android.content.res.Configuration;

public aspect ConfigurationChangeInterceptor {
    public static class DefaultChangeListener extends Activity {
        @Override
        public void onConfigurationChanged (Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            doDefaultOnConfigurationChanged();
        }
    }

    declare parents : Activity+ && !Activity extends DefaultChangeListener;

    private static void doDefaultOnConfigurationChanged() {
        System.out.println("onConfigurationChanged - aspect override");
    }
}