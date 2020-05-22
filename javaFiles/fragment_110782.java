package com.jkhong.app;

import android.app.Activity;
import android.content.res.Configuration;

public class Application {
    public static void main(String[] args) {
        Configuration newConfig = new Configuration();
        System.out.println("Activity");
        new Activity().onConfigurationChanged(newConfig);
        System.out.println("\nOverridingActivity");
        new OverridingActivity().onConfigurationChanged(newConfig);
        System.out.println("\nNonOverridingActivity");
        new NonOverridingActivity().onConfigurationChanged(newConfig);
    }
}