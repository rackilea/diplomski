@TargetApi(16)
public void requestSingleUpdate() {
    // TODO: Comment-out this line.
    // Looper.prepare();

    // only works with SDK Version 23 or higher
    if (android.os.Build.VERSION.SDK_INT >= 23) {
        if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // permission is not granted
            Log.e("SiSoLocProvider", "Permission not granted.");
            return;
        } else {
            Log.d("SiSoLocProvider", "Permission granted.");
        }
    } else {
        Log.d("SiSoLocProvider", "SDK < 23, checking permissions should not be necessary");
    }

    final long startTime = System.currentTimeMillis();
    fusedTrackerCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            // TODO: These lines of code will run on UI thread.
            if ((locationResult.getLastLocation() != null) && (System.currentTimeMillis() <= startTime + 30 * 1000)) {
                System.out.println("LOCATION: " + locationResult.getLastLocation().getLatitude() + "|" + locationResult.getLastLocation().getLongitude());
                System.out.println("ACCURACY: " + locationResult.getLastLocation().getAccuracy());
                mFusedLocationClient.removeLocationUpdates(fusedTrackerCallback);
            } else {
                System.out.println("LastKnownNull? :: " + (locationResult.getLastLocation() == null));
                System.out.println("Time over? :: " + (System.currentTimeMillis() > startTime + 30 * 1000));
            }

            // TODO: After receiving location result, remove the listener.
            mFusedLocationClient.removeLocationUpdates(this);
        }
    };

    LocationRequest req = new LocationRequest();
    req.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    req.setFastestInterval(2000);
    req.setInterval(2000);
    // Receive location result on UI thread.
    mFusedLocationClient.requestLocationUpdates(req, fusedTrackerCallback, Looper.getMainLooper());
}