package android.app;

import android.content.res.Configuration;

public class Activity {
    public void onConfigurationChanged (Configuration newConfig) {
        System.out.println("onConfigurationChanged - default implementation");
    }
}