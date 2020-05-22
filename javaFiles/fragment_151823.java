GPSTracker gps;
  gps = new GPSTracker(this);
        // check if GPS enabled
        if (gps.canGetLocation()) {
            startService(new Intent(getApplicationContext(), GPSTracker.class));
            } else {
            gps.showSettingsAlert();
        }