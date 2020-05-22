package com.servtest.test;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class LocationService extends Service implements LocationListener {

    private final IBinder mBinder = new LocalBinder();

    @Override
    public void onLocationChanged(Location arg0) {}
    @Override
    public void onProviderDisabled(String arg0) {}
    @Override
    public void onProviderEnabled(String arg0) {}
    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {}

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("SVTEST", "Loc service ONBIND");
        return mBinder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("SVTEST", "Loc service ONUNBIND");
        return super.onUnbind(intent);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Won't run unless it's EXPLICITLY STARTED
        Log.d("SVTEST", "Loc service ONSTARTCOMMAND");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SVTEST", "Loc service ONDESTROY");
    }

    public class LocalBinder extends Binder {
        LocationService getService() {
            // Return this instance of LocalService so clients can call public methods
            return LocationService.this;
        }
    }

    public void methodInTheService() {
        // A method you can call in the service
        Log.d("SVTEST", "Loc service EXECUTING THE METHOD");
    }
}