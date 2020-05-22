package com.company.myapp;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

import com.company.myapp.Example;

public class ExampleApplication extends Application 
{
    private static ExampleApplication instance = new ExampleApplication();

    public ExampleApplication() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // register device for parse
        Parse.initialize(this, "APP_KEY", "CLIENT_KEY");
        PushService.setDefaultPushCallback(this, Example.class);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}