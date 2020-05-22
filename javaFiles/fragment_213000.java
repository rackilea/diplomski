@Override
public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    switch (requestCode) {
        case PERMISSION_REQUEST_CODE:
            if (verifyGrantResults(grantResults)) {
                Toast.makeText(getApplicationContext(), "Permission Granted. Now you can read/write data.",
                        Toast.LENGTH_LONG).show();
                        //start Async Task here
            } else {
                Toast.makeText(getApplicationContext(),"Permission Denied. You cannot read/write data.",
                        Toast.LENGTH_LONG).show();
            }
            break;
    }
}

private boolean verifyGrantResults(final int[] grantResults) {
        boolean permissionsGranted = true;
        if (grantResults.length > 0) {
            for (int result : grantResults) {
                if (result == PackageManager.PERMISSION_DENIED) {
                    permissionsGranted = false;
                }
            }
            return permissionsGranted;
        }
        return false;
    }