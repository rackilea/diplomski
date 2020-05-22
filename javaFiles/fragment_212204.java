private GoogleMap mMap;
// Create a LatLngBounds that includes Australia.
private LatLngBounds AUSTRALIA = new LatLngBounds(
  new LatLng(-44, 113), new LatLng(-10, 154));

// Set the camera to the greatest possible zoom level that includes the bounds
mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(AUSTRALIA, 0));