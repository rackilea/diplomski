LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    if (locationManager.getProvider(LocationManager.GPS_PROVIDER) == null) {
        Log.v(TAG, "GPS not available");
    }
    else
    {
        Log.v(TAG, "GPS available");
    }