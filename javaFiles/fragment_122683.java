package com.example.giacomob.myapplication;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by Giacomo B on 07/08/2015.
 */
public class Track extends ActionBarActivity implements LocationListener
{
    String providerId = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
    private  final int MIN_DIST=20;
    private static final int MIN_PERIOD=30000; */
    private String providerId = LocationManager.GPS_PROVIDER;
    private LocationManager locationManager=null;
    private static final int MIN_DIST=20;
    private static final int MIN_PERIOD=30000;

    /*if(!providerId.contains("gps"))

    {
        final Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
        intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
        intent.setData(Uri.parse("3"));
        sendBroadcast(intent);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        this.locationManager  = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    protected void onResume()
    {
        if (locationManager == null)
            locationManager  = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (!locationManager.isProviderEnabled(providerId))
        {
            Intent gpsOptionsIntent = new Intent(
                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(gpsOptionsIntent);
        }
        super.onResume();
        if (!locationManager.isProviderEnabled(providerId))
        {
            Intent gpsOptionsIntent = new Intent(
                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(gpsOptionsIntent);
        }
        else
        {
            locationManager.requestLocationUpdates(providerId, MIN_PERIOD, MIN_DIST, this);
        }
    }

    private void updateGUI(Location location)
    {
        double latitude=location.getLatitude();
        double longitude=location.getLongitude();
        String msg="Ci troviamo in coordinate ("+latitude+","+longitude+")";
        TextView txt= (TextView) findViewById(R.id.locationText);
        txt.setText(msg);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        if (locationManager != null)
            locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location)
    {
        updateGUI(location);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle)
    { }

    @Override
    public void onProviderEnabled(String s)
    { }

    @Override
    public void onProviderDisabled(String s)
    {  }
}