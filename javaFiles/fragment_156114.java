package com.MyUniqueDomain.MyUniquePackage;

import android.annotation.TargetApi;
import android.os.Bundle;
import org.apache.cordova.*;

public class MainActivity extends DroidGap {

    private int retryCount = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.setStringProperty("loadingDialog", "Please wait -- loading...");
        super.init();
        if(android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            fixJellyBeanIssues();
        }
        super.loadUrl("file:///android_asset/www/index.html");
    }

    @TargetApi(16)
    protected void fixJellyBeanIssues() {
        System.out.println(super.appView.toString());
        try {
            super.appView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        } catch(NullPointerException e) {
            System.out.println(e.toString());
        }
    }

    // catch an error and if try again 1x or quit
    @Override
    public void onReceivedError( int errorCode, String description, String failingUrl)
    {
        if(retryCount < 3) {
            retryCount++;
            System.out.println("Connection failed, trying again. Retry Count: "+retryCount);
            super.loadUrl("file:///android_asset/www/index.html");
        } else {
            System.out.println("Sorry, it failed three times so I give up.");
            super.loadUrl("file:///android_asset/www/fail.html");
        }
        return;
    }
}