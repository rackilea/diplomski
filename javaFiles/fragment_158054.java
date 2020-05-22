public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        location = locationManager.getLastKnownLocation(provider);
                } else {
                    Toast.makeText(getApplicationContext(), ("Please provide access to Location"), Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
  }