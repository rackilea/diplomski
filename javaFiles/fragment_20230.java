@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
        @Override
        public void onMapClick(LatLng latLng) {
            // latLng is the lcoation, tapped by the user on the map. lets save it
            chosen_location = new LatLng(latLng.latitude, latLng.longitude);
        }
    });
}