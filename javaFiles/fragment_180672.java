if(location!=null) 
 {
double lat =location.getLatitude(); 
double lng =location.getLongitude();
mMap.addMarker(new MarkerOptions().position(new 
LatLng(lat,lng)).title("Marker")); }