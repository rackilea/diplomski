// Here, thisActivity is the current activity
if (ContextCompat.checkSelfPermission(thisActivity,
            Manifest.permission.READ_EXTERNAL_STORAGE)
    != PackageManager.PERMISSION_GRANTED) {

    ActivityCompat.requestPermissions(thisActivity,
            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
            PERMISSION_REQUEST_CODE);

    // PERMISSION_REQUEST_CODE is an
    // app-defined int constant. The callback method gets the
    // result of the request.
  }
}