LocationCallback mLocationCallback = new LocationCallback() {
    @Override
    public void onLocationResult(LocationResult locationResult) {
        List<Location> locationList = locationResult.getLocations();
        if (locationList.size() > 0) {
            //The last location in the list is the newest
            Location location = locationList.get(locationList.size() - 1);
            Log.i(TAG, "Location " + location.getLatitude() + " " + location.getLongitude());

            mLastLocation = location;
            if (mCurrLocationMarker != null) {
                mCurrLocationMarker.remove();
            }

            //Create instance for current user lat and lng
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

            // Add user position marker
            currentUserPositionMarker(latLng);

            //move map camera
            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, CURRENT_MAP_ZOOM));

        }
    }
};

/**
 * Add Marker for user current position
 *
 * @param latLng current lat and lng of user
 */
private void currentUserPositionMarker(LatLng latLng) {
    MarkerOptions markerOptions = new MarkerOptions();
    markerOptions.position(latLng);
    markerOptions.title(CURRENT_POSITION);
    mCurrLocationMarker = gMap.addMarker(markerOptions);

     //move map camera
     gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, CURRENT_MAP_ZOOM));
}


@Override
public void onPause() {
    super.onPause();

    if (mFusedLocationProviderClient != null) {
        mFusedLocationProviderClient.removeLocationUpdates(mLocationCallback);
    }
}

@SuppressLint("MissingPermission")
@Override
public void onMapReady(GoogleMap googleMap) {
    gMap = googleMap;
    gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    gMap.getUiSettings().setMapToolbarEnabled(false);

    mLocationRequest = new LocationRequest();
    mLocationRequest.setInterval(SET_INTERVAL_FOR_ACTIVE_LOCATION_UPDATES); // 3 seconds interval
    mLocationRequest.setFastestInterval(SET_INTERVAL_FOR_ACTIVE_LOCATION_UPDATES);
    mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

    if (isFineLocationPermissionGranted())
        mFusedLocationProviderClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
}