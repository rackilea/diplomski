// latitude and longitude
double latitude = ;
double longitude = ;

// create marker
MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Hello Maps ");

// adding marker
googleMap.addMarker(marker);