ActivityCompat.requestPermissions(thisActivity,
                new String[]{               
                  Manifest.permission.ACCESS_COARSE_LOCATION,
                  Manifest.permission.READ_EXTERNAL_STORAGE
                },
                PERMISSIONS_REQUEST_CODE);