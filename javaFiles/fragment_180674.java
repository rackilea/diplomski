@Override
public void onLocationChanged(Location location) {

    double latitude = location.getLatitude();
    double longitude = location.getLongitude();

    myLatLng = new LatLng(latitude, longitude);

    zoomToPoints();

    if(!isDirectionDrawn) {

        new LongOperation().execute("");
    }https://developers.google.com/android/reference/com/google/android/gms/location/FusedLocationProviderApi
}

private void moveToCurrentLocation(LatLng currentLocation)
    {
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));
    // Zoom in, animating the camera.
    mMap.animateCamera(CameraUpdateFactory.zoomIn());
    // Zoom out to zoom level 10, animating with a duration of 2 seconds.
    mMap.an


}