private void checkExternalStoragePermission() {
    int permissionCheck = ContextCompat.checkSelfPermission(
            this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
        Log.i("Permission", "We dont have permission.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 225);
    } else {
        Log.i("Permission", "You already have permission!");
    }
}