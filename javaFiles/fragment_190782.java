@Override
public void onLocationChanged(Location location) {
lastLocation = location;

LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
currentLocationMarker.setPosition(latLng);
// make sure following setTitle gets String from getAddressForLatLng
currentLocationMarker.setTitle(getAddressForLatLng(latLng));

mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
}