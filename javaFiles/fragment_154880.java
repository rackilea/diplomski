@Override
protected void onResume() {
    super.onResume();

    if (checkLocationPermission()) {
       if (ContextCompat.checkSelfPermission(this,
           Manifest.permission. ACCESS_FINE_LOCATION)
           == PackageManager.PERMISSION_GRANTED) {
                  //start your service here
                       startService(new Intent(this, MyService.class)); 

       }
    }

}