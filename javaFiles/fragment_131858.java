@Override
    public void onRequestPermissionsResult(int requestCode,
                                   String permissions[], int[] grantResults) {
    switch (requestCode) {
        case 1011: {

      // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            // Here user granted the permission     
            } else {

            // permission denied, boo! Disable the
            // functionality that depends on this permission.
                Toast.makeText(MainActivity.this, "Permission denied to read your Camera", Toast.LENGTH_SHORT).show();
            }
            return;
         }
       }
    }