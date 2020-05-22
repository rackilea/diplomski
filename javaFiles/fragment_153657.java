if (ContextCompat.checkSelfPermission(YourActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED
                            &&
                            ContextCompat.checkSelfPermission(YourActivity.this,
                                    Manifest.permission.ACCESS_COARSE_LOCATION)
                                    != PackageManager.PERMISSION_GRANTED) {
                        askForLocationPermissions();
      } else {
          //do your work
     }