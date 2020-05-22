private void checkLocationSettings() {

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);

        final Task<LocationSettingsResponse> result =
                LocationServices.getSettingsClient(MapsActivity.this).checkLocationSettings(builder.build());

        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {

                Log.e(TAG, "onComplete() called with: task = [" + task.isComplete() + "]");
                // All location settings are satisfied. The client can initialize
                // location requests here.
                // ...
                getLastKnownLocation(mFusedLocationClient);
            }
        });


        result.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "onFailure() called with: e = [" + e + "]");
                if (e instanceof ResolvableApiException) {
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(MapsActivity.this,
                                REQUEST_CHECK_SETTINGS);
                    } catch (IntentSender.SendIntentException sendEx) {
                        // Ignore the error.
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("MapsActivity", "onActivityResult() called with: requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data + "]");
        getLastKnownLocation(mFusedLocationClient);
    }


    public void getLastKnownLocation(FusedLocationProviderClient cl) {
        // Get last location
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        Log.e(TAG, "onSuccess() called with: location = [" + location + "]");
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            longitude = location.getLongitude();
                            latitude = location.getLatitude();
                            Log.e("MapsActivity", "onSuccess() called with: location = [" + location + "]");
                            LatLng mCurrentLocation = new LatLng(latitude, longitude);
                            mMap.addMarker(new MarkerOptions().position(mCurrentLocation).title("Current position"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(mCurrentLocation));

                            // Set zoom level
                            mMap.animateCamera(CameraUpdateFactory.zoomTo(19.0f));
                            Toast.makeText(getApplicationContext(), "value is " + latitude + "poi" + longitude, Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                    createLocationRequest();
                    checkLocationSettings();
                } else {
                    Toast.makeText(getApplicationContext(), "This app requires location permission to be granted", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;


        }