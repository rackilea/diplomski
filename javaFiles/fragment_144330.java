public class LocationFinderFragment extends Fragment implements
        GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener {

    public interface OnNewLocationFoundListener {
        public void OnNewLocationFound(Location location);
    }

    private static final String TAG = "LocationFinderFragment";
    private static final long DEFAULT_UPDATE_LOCATION_INTERVAL = 30 * 1000; // update every 30 seconds
    private static final long DEFAULT_TERMINATE_SAT_FINDING = 1 * 60 * 60 * 1000; // for 1 hour

    private OnNewLocationFoundListener listener;  // Listener of fragments
    private OnNewLocationFoundListener listener2; // Listener of MainFragmentHolder
    private Context context;
    private LocationClient mLocationClient;
    private static double lat = 0;
    private static double lng = 0;
    private static long lastTime = 0;

    private LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            if(location == null)
                return;

            if(lat == location.getLatitude()  &&  lng == location.getLongitude()) {
                Log.e(TAG, "location not changed.");
                return;
            }

            lat = location.getLatitude();
            lng = location.getLongitude();
            Log.i(TAG, "Location changed to (" + lat + ", " + lng + ")");

            // Ask fragment to get new data and update screen
            listener.OnNewLocationFound(location);

            // Display toast notification every minute (instead of every 30 seconds)
            DateTime time = new DateTime();
            long currentTime = time.getMillis();
            if(currentTime > lastTime + 1 * 60 * 1000) {
                listener2.OnNewLocationFound(location);
                lastTime = currentTime;
            }
        }
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener2 = (OnNewLocationFoundListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnNewLocationFoundListener interface.");
        }

        Log.i(TAG, "Fragment attached to activity.");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Getting context
        context = getActivity().getApplicationContext();

        // Get location manager
        mLocationClient = new LocationClient(context, this, this);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Get location
        if(mLocationClient != null)
            mLocationClient.connect();
    }

    @Override
    public void onPause() {
        super.onPause();

        // remove listener in order to save resource
        if(mLocationClient != null)
            mLocationClient.disconnect();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // remove listener in order to save resource
        if(mLocationClient != null)
            mLocationClient.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Location Connected.");
        // Get last known location
        Location lastLocation = mLocationClient.getLastLocation();
        mLocationListener.onLocationChanged(lastLocation);

        if(!SpGodMode.isLocationModeEnabled(context)) {
            // Create location request
            LocationRequest locationRequest = LocationRequest.create()
                    .setInterval(DEFAULT_UPDATE_LOCATION_INTERVAL)
                    .setExpirationDuration(DEFAULT_TERMINATE_SAT_FINDING)
                    .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
            mLocationClient.requestLocationUpdates(locationRequest, mLocationListener);
        } else {
            String strLoc = SpGodMode.getLocation(context);
            if(strLoc != null) {
                String lat = strLoc.substring(0, strLoc.indexOf(","));
                String lng = strLoc.substring(strLoc.indexOf(",") + 1);
                Location location = new Location("");
                try {
                    location.setLatitude(Double.parseDouble(lat));
                    location.setLongitude(Double.parseDouble(lng));
                    mLocationListener.onLocationChanged(location);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Wrong lat/lng for parsing as Double.");
                    Toast.makeText(context, "Wrong lat/lng", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onDisconnected() {
        Log.i(TAG, "Location Disconnected.");
        if(mLocationClient != null  &&  mLocationClient.isConnected())
            mLocationClient.removeLocationUpdates(mLocationListener);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.e(TAG, "Connection failed listener.");
    }

    public void setLocationListener(OnNewLocationFoundListener listener) {
        this.listener = listener;
    }

    public void disconnectLocation() {
        mLocationClient.disconnect();
    }
}