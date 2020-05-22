public void drawMarker(double lat,double lon) {
 if (mMap != null) { 
   MarkerOptions marker = new MarkerOptions().position(new LatLng(lat, lon)).title(" Maps Tutorial").snippet("Android Ruler");      
   marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)); 
   // Moving Camera to a Location with animation 
   CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(12).build();
   mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)); mMap.addMarker(marker); 
  } 
  }