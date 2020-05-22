public class MapsFragmentDemo extends com.google.android.gms.maps.MapFragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener, LocationListener {


private static final int REQUEST_LOCATION = 1;
private final int REQUEST_CHECK_SETTINGS = 300;
GoogleMap mGoogleMap;
LocationRequest mLocationRequest;
GoogleApiClient mGoogleApiClient;
Location mLastLocation;
Marker mCurrLocationMarker;
boolean isFragmentVisible = false;
private LocationSettingsRequest.Builder builder;
private PendingResult<LocationSettingsResult> result;

@Override
public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (isVisibleToUser) {
        isFragmentVisible = true;
        Log.d("MapsFragment", "Inside Visible");
        getMapAsync(this);
        createLocationRequest();
        buildGoogleApiClient();

    }
}


protected void createLocationRequest() {
    mLocationRequest = new LocationRequest();
    mLocationRequest.setInterval(1000);
    mLocationRequest.setFastestInterval(1000);
    mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    mLocationRequest.setSmallestDisplacement(.5f);

}


@Override
public void onResume() {
    super.onResume();
    Log.d("MapsFragment", "Inside onResume");
    if (isFragmentVisible) {
        Log.d("MapsFragment", "Inside onResume true");
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            if (checkAccessPermission())
                startLocationUpdates();

            else
                askForPermission();
        }
    }
}

@Override
public void onPause() {
    super.onPause();
    Log.d("MapsFragment", "Inside onPause");
    stopLocationUpdates();
}

@Override
public void onStop() {
    super.onStop();
    Log.d("MapsFragment", "onStop fired ..............");
    if (mGoogleApiClient != null && !mGoogleApiClient.isConnected())
        mGoogleApiClient.disconnect();

}

protected void stopLocationUpdates() {
    if (mGoogleApiClient != null)
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
}

protected void startLocationUpdates() {
    if (mGoogleApiClient != null) {

        accessLocation();
    }
}

private boolean checkAccessPermission() {
    return (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED);
}

@SuppressWarnings("MissingPermission")
private void accessLocation() {
    LocationServices.FusedLocationApi.requestLocationUpdates(
            mGoogleApiClient, mLocationRequest, this);
    if (mGoogleMap != null)
        mGoogleMap.setMyLocationEnabled(true);
}

private void askForPermission() {
    // Should we show an explanation?
    if (android.support.v4.app.ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
            android.Manifest.permission.ACCESS_FINE_LOCATION)) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Location permission needed")
                .setMessage("This app needs the Location permission, please accept to use location functionality")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //prompt the user once the explanation has been shown
                        FragmentCompat.requestPermissions(MapsFragmentDemo.this,
                                new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                                REQUEST_LOCATION);
                    }
                })
                .create()
                .show();
    } else
        FragmentCompat.requestPermissions(MapsFragmentDemo.this,
                new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_LOCATION);
}


//Call back method for when map is ready to be used.
@Override
public void onMapReady(GoogleMap googleMap) {
    Log.d("MapsFragment", "Inside onMapReady");

    mGoogleMap = googleMap;
    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


}

private void buildGoogleApiClient() {
    Log.d("MapsFragment", "Inside buildGoogleApiClient");

    mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build();
    mGoogleApiClient.connect();
}


@Override
public void onConnected(@Nullable Bundle bundle) {
    Log.d("MapsFragment", "Inside onConnected");

    builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
    result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
    result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
        @Override
        public void onResult(LocationSettingsResult result) {
            final Status status = result.getStatus();
            final LocationSettingsStates mState = result.getLocationSettingsStates();
            switch (status.getStatusCode()) {
                case LocationSettingsStatusCodes.SUCCESS:
                    if (!checkAccessPermission()) {

                        askForPermission();

                    } else
                        startLocationUpdates();
                    break;
                case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                    try {
                        status.startResolutionForResult(getActivity(), REQUEST_CHECK_SETTINGS);
                    } catch (IntentSender.SendIntentException e) {
                    }
                    break;
                case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                    break;
            }
        }
    });


}

public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
        case REQUEST_CHECK_SETTINGS:
            switch (resultCode) {
                case Activity.RESULT_OK:
                    if (!checkAccessPermission()) {

                        askForPermission();

                    } else
                        startLocationUpdates();
                    break;
                case Activity.RESULT_CANCELED:

                    break;
            }
            break;
    }
}

@Override
public void onConnectionSuspended(int i) {

}

@Override
public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

}

@Override
public void onLocationChanged(Location location) {
    mGoogleMap.clear();
    Log.d("MapsFragment", "Inside onLocationChanged");
    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

    MarkerOptions markerOptions = new MarkerOptions();
    markerOptions.position(latLng);
    markerOptions.title("Current Position");
    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
    Marker currLocationMarker = mGoogleMap.addMarker(markerOptions);


    CameraPosition cameraPosition = new CameraPosition.Builder()
            .target(latLng).zoom(14).build();


    mGoogleMap.animateCamera(CameraUpdateFactory
            .newCameraPosition(cameraPosition));

    //Optionally, stop location updates if only current location is needed
    if (mGoogleApiClient != null) {
        stopLocationUpdates();
    }

}

@Override
public void onRequestPermissionsResult(int requestCode, String permissions[]
        , int[] grantResults) {
    Log.d("MapsFragment", "Inside onRequestPermissionsResult");

    switch (requestCode) {
        case REQUEST_LOCATION: {
            //If request is cancelled, the results arrays are empty
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission was granted
                accessLocation();
            } else {
                // permission was denied
                Toast.makeText(getActivity(), "Permission denied", Toast.LENGTH_LONG).show();
            }
            return;
        }//Other case lines to check for other permissions this app might request
    }

}