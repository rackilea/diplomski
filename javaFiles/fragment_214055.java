@Override
    public void onLocationChanged(Location location) {
        handleNewLocation(location);
    }

    private void handleNewLocation(Location location) {
        Log.d(TAG, location.toString());

        mLatitude = location.getLatitude();
        mLongitude = location.getLongitude();
        getForecast(mLatitude, mLongitude);
        getCityName();

    }