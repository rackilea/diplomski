locationClient = new LocationClient(activity, this, this);
locationClient.connect();

public void onConnected(Bundle dataBundle) {
    // Create a new global location parameters object
    locationRequest = LocationRequest.create();
    // Set the update interval 70% of the interval
    // this is to make sure we have an updated location
    // when the animation completes
    locationInterval = (long) (interval * .70);
    locationRequest.setInterval(locationInterval);
    locationRequest.setFastestInterval(locationInterval);
    locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    locationClient.requestLocationUpdates(locationRequest, this);
}

@Override
public void onLocationChanged(Location location) {
            // here you have a location to do with what you will
}