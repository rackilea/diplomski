@Override
public void onConnected(@Nullable Bundle bundle) {
    if( HelperUtils.isGpsOpen(getApplicationContext()) ) {
        startListenLocation();
    }
}

@Override
public void startListenLocation() {
    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        //ask permission whatever you want to do
    } else {
        if(mGoogleApiClient==null) {
            buildGoogleApiClient();
        } else {
            if(mGoogleApiClient.isConnected()) {
                mLocationRequest = new LocationRequest();
                mLocationRequest.setInterval(UPDATE_INTERVAL);
                mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
                mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                mLocationRequest.setSmallestDisplacement(DISPLACEMENT);
                Location mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
                //here I am checking null thats where you get null
                if(mCurrentLocation!=null) {
                    mPresenter.onNewLocation(getDeviceId(),mCurrentLocation.getLatitude(),mCurrentLocation.getLongitude());
                }
                // then I am tracking user location  ,  this will trigger onLocationChanged method when a new location arrived so you can handle new location
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
            } else {
                if(!mGoogleApiClient.isConnecting())
                buildGoogleApiClient();
            }
        }

    }

}

@Override
public void onLocationChanged(Location location) {
    // I am just checking null again, more cautious I am :)
    if(location!=null) // handle it
}