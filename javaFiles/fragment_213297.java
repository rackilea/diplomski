@Override
public void onMapClick(LatLng latLng) {
    MarkerOptions marker = new MarkerOptions()
            .position(latLng);
    this.googleMap.addMarker(marker);
}