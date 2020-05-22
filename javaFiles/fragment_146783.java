@Override
    protected void onStart() {
        super.onStart();
        mLocationClient.connect();
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        locationManager.requestLocationUpdates(provider, 0, 0, this);
    }