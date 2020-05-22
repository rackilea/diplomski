public class GPSTracker extends Service {

private static Context mContext;
// flag for GPS status
boolean isGPSEnabled = false;
// flag for network status
boolean isNetworkEnabled = false;
// flag for GPS status
boolean canGetLocation = false;
protected LocationManager locationManager;
static String latitude_s, longitude_s;
Thread triggerService;
private final IBinder mBinder = new MyBinder();

public GPSTracker() {
    super();
}


public GPSTracker(Context context) {
    mContext = context;
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    //Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
    Log.i(LOG, "Service started");
    if (intent != null) {
        addLocationListener();
     }
    return START_STICKY;
}

private void addLocationListener() {
    triggerService = new Thread(new Runnable() {
        public void run() {
            try {
                Looper.prepare();//Initialise the current thread as a looper.
                locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);

                //Criteria c = new Criteria();
                //c.setAccuracy(Criteria.ACCURACY_COARSE);

                //final String PROVIDER = locationManager.getBestProvider(c, true);

                MyLocationListener myLocationListener = new MyLocationListener();
                if (checkLocationPermission()) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, myLocationListener);
                }
                Log.d("LOC_SERVICE", "Service RUNNING!");
                Looper.loop();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }, "LocationThread");
    triggerService.start();
}

public static void updateLocation(Location location) {
    Context appCtx = Global_variable.getAppContext();

    double latitude, longitude;

    latitude = location.getLatitude();
    longitude = location.getLongitude();
    try {
        latitude_s = Double.toString(latitude);
        longitude_s = Double.toString(longitude);
    } catch (Exception e) {

    }
    Intent filterRes = new Intent();
    filterRes.setAction("mypackage.action.LOCATION");
    filterRes.putExtra("latitude", latitude);
    filterRes.putExtra("longitude", longitude);
    filterRes.putExtra("id", id);
    appCtx.sendBroadcast(filterRes);
}


class MyLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        updateLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}


public boolean checkLocationPermission() {
    String permission = "android.permission.ACCESS_FINE_LOCATION";
    int res = mContext.checkCallingOrSelfPermission(permission);
    return (res == PackageManager.PERMISSION_GRANTED);
}


@Override
public void onCreate() {
    super.onCreate();
    Log.d(LOG, "Service created");
}


@Override
public void onDestroy() {
    super.onDestroy();
    Log.d(LOG, "Service destroyed");
}


/**
 * Function to check GPS/wifi enabled
 *
 * @return boolean
 */
public boolean canGetLocation() {
    locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
    // getting GPS status
    isGPSEnabled = locationManager
            .isProviderEnabled(LocationManager.GPS_PROVIDER);

    // getting network status
    isNetworkEnabled = locationManager
            .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

    if (!isGPSEnabled && !isNetworkEnabled) {
        // location service disabled
        canGetLocation = false;
    } else {
        canGetLocation = true;
    }
    return canGetLocation;
}

/**
 * Function to show settings alert dialog
 * On pressing Settings button will lauch Settings Options
 */
public void showSettingsAlert() {
    AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
    // Setting Dialog Title
    alertDialog.setTitle("GPS is settings");
    // Setting Dialog Message
    alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");
    // On pressing Settings button
    alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            mContext.startActivity(intent);
        }
    });

    // on pressing cancel button
    alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });

    // Showing Alert Message
    alertDialog.show();
}

@Override
public IBinder onBind(Intent arg0) {
    return mBinder;
}

public class MyBinder extends Binder {
    GPSTracker getService() {
        return GPSTracker.this;
    }
}

public String getLatitude_s() {
    return latitude_s;
}

public String getLongitude_s() {
    return longitude_s;
}