if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
    // Do the file write
} else {
    // Request permission from the user
    ActivityCompat.requestPermissions(this, 
            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
    ...
}