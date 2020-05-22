LocationManager mng = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
Location location = mng.getLastKnownLocation(mng.getBestProvider(new Criteria(), false));

double lat = location.getLatitude();
double lon = location.getLongitude();

CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 10);
mMap.animateCamera(cameraUpdate);