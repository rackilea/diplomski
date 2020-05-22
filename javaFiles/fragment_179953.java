package com.servtest.test;

import com.servtest.test.LocationService.LocalBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class ServiceTestActivity extends Activity {

    boolean mServiceConnected = false;
    boolean mBound = false;
    private LocationService mLocnServ;

    ServiceConnection mServconn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("SVTEST", "Activity service connected");
            LocalBinder binder = (LocalBinder) service;
            mLocnServ = binder.getService();
            // Can't call this methodInTheService UNTIL IT'S BOUND!
            mLocnServ.methodInTheService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("SVTEST", "Activity service disconnected");
            mBound = false;
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("SVTEST", "Activity onStart");
        mServiceConnected = bindService(new Intent(
                "com.servtest.test.LOCATIONSERVICE"), mServconn,
                Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SVTEST", "Activity onResume");
    }
    @Override
    public void onPause() {
        Log.d("SVTEST", "Activity onPause");
        super.onPause();
    }
    @Override
    public void onStop() {
        Log.d("SVTEST", "Activity onStop");
        if (mBound) {
            unbindService(mServconn);
            mBound = false;
        }
        super.onStop();
    }

}