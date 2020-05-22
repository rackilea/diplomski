String Latitude = objectInner.getString("Latitude");
String Longitude = objectInner.getString("Longitude");

double lat =Double.parseDouble(Latidute);
double lng =Double.parseDouble(Longitude);


LatLng location = new LatLng(lat, lng);
mMap.addMarker(new MarkerOptions().position(location).title("Camera Location"));
mMap.moveCamera(CameraUpdateFactory.newLatLng(location));//this will make camera focus on the last marker location