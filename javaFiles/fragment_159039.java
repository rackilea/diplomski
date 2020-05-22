private void setUpMapIfNeeded() {
    ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
            .getMapAsync(this);
}

@Override
public void onMapReady(final GoogleMap googleMap) {
    mMap = googleMap;
    setUpMap();
}