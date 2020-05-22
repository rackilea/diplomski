public class GpsHandler extends Service implements LocationListener{
private static final String TAG = "GpsHandler";
private LocationManager mLocationManager = null;
private static final int LOCATION_INTERVAL = 0;
private static final float LOCATION_DISTANCE = 0f;
private final String LOCATION_BROADCAST_TAG = "android.LOCATION";
private final String LOCATION_EXTRA_TAG = "Location";
private Location mLastLocation = null;
@Nullable
@Override
public IBinder onBind(Intent intent) {
    return null;
}
@Override
public void onCreate()
{
    Toast.makeText(this, "Service Started, onCreate", Toast.LENGTH_LONG).show();
}
@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    // Let it continue running until it is stopped.

    Toast.makeText(this, "Service Started, onStartCommand", Toast.LENGTH_LONG).show();
    if (mLocationManager == null)
    {
        mLocationManager = (LocationManager)getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
    }
    mLastLocation = new Location(LocationManager.GPS_PROVIDER);
    try {
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE, this);
        mLastLocation.set(mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));
    } catch (java.lang.SecurityException ex) {
    Log.i(TAG, "fail to request location update, ignore", ex);
} catch (IllegalArgumentException ex) {
    Log.d(TAG, "gps provider does not exist " + ex.getMessage());
}
    return START_STICKY;
}

@Override
public void onDestroy() {
    super.onDestroy();
    if (mLocationManager != null)
    {
        try {
            mLocationManager.removeUpdates(this);
        } catch (Exception ex) {
            Log.i(TAG, "fail to remove location listners, ignore", ex);
        }
    }
    Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
}
@Override
public void onProviderDisabled(String provider) {

    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    startActivity(intent);
    Toast.makeText(getBaseContext(), "Gps is turned off!! ",
            Toast.LENGTH_SHORT).show();
}
@Override
public void onLocationChanged(Location location)
{
    Toast.makeText(this, "Location Changed", Toast.LENGTH_LONG).show();
    if(location.getAccuracy()<4*mLastLocation.getAccuracy())
    {
        mLastLocation.set(location);
        Intent intent = new Intent(LOCATION_BROADCAST_TAG).putExtra(LOCATION_EXTRA_TAG, location);
        sendBroadcast(intent);
    }
}
@Override
public void onProviderEnabled(String provider){}
@Override
public void onStatusChanged(String provider, int status, Bundle extras){}
}