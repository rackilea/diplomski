@Override
public void onMapReady(GoogleMap map) {
    mMap = map;

    double myCurrentLatitude = getGPS()[0];
    double myCurrentLongitude = getGPS()[1];

    CameraPosition myCurrentLocation = CameraPosition.builder()
            .target(new LatLng(myCurrentLatitude, myCurrentLongitude))
            .zoom(12)
            .bearing(0)
            .tilt(2)
            .build();

   mMap.moveCamera(CameraUpdateFactory.newCameraPosition(myCurrentLocation));
   mMap.getUiSettings().setScrollGesturesEnabled(true);  
}