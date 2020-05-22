@Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   fp = getFile();

                } else {
                    Toast.makeText(MainActivity.this, "Please give your permission.", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }