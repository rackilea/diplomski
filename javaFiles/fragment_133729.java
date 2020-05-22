private static final int PERMISSION_ACCESS_COARSE_LOCATION = 0;

   if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                PERMISSION_ACCESS_COARSE_LOCATION);
    }