@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    switch (requestCode) {
        case /*our request code from before*/: {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onPermissionGranted();
            } else {
                Toast.makeText(this, "Permissions are required in order to run this app!", Toast.LENGTH_SHORT).show();
                finish();
            }
            return;
        }
    }
}