latitude = gps.getLatitude();
        longitude = gps.getLongitude();
        // Toast.makeText(getApplicationContext(), "  "+latitude+" "+longitude,Toast.LENGTH_LONG).show();
        Longitude = Double.toString(latitude);
        Latitude = Double.toString(longitude);
    }
    // Add a marker in Sydney and move the camera
    LatLng me = new LatLng(latitude, longitude);
    //MyMarker= mMap.addMarker(new MarkerOptions().position(me).snippet("My Location"));

     mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(me),17); //This is where it should be


    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        return;
    }
    mMap.setMyLocationEnabled(true);


}