if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

           requestPermissions(new String[]{
                   android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION,
                   android.Manifest.permission.INTERNET
           }, 10);

        } else {
            //Added:
            locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
        }
    }
    else {
        locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
    }