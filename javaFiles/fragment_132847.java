locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    com.google.android.gms.location.LocationListener mLocationListener = new com.google.android.gms.location.LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {
            listener.onLocation(location);
        }
    };
    if(location != null) {
        listener.onLocation(location);
    }else{
        locationListener = new android.location.LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                listener.onLocation(location);
                locationManager.removeUpdates(locationListener);
                Log.d(TAG,"Location: " + String.valueOf(location.getLongitude()));
            }
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }
            @Override
            public void onProviderEnabled(String s) {

            }
            @Override
            public void onProviderDisabled(String s) {

            }
        };
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }