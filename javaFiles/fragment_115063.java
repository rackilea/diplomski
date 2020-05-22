package com.my.app;
import android.app.Application;

public class MyApplication extends Application {
    @Override public void onCreate() {...}

    public void doSomething() {
        // getApplicationContext() getter is available here
    }
}