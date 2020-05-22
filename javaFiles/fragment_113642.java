private boolean checkAndRequestPermissions() {
    int permissionReadStorage = ContextCompat.checkSelfPermission(this,
            Manifest.permission.READ_EXTERNAL_STORAGE);
    int permissionCamera = ContextCompat.checkSelfPermission(this,
            Manifest.permission.CAMERA);
    int permissionWriteStorage = ContextCompat.checkSelfPermission(this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE);

    List<String> listPermissionsNeeded = new ArrayList<>();
    if (permissionCamera != PackageManager.PERMISSION_GRANTED) {
        listPermissionsNeeded.add(Manifest.permission.CAMERA);
    }
    if (permissionReadStorage != PackageManager.PERMISSION_GRANTED) {
        listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
    }
    if (permissionWriteStorage != PackageManager.PERMISSION_GRANTED) {
        listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    if (!listPermissionsNeeded.isEmpty()) {
        ActivityCompat.requestPermissions((Activity) this,
                listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
                REQUEST_ID_MULTIPLE_PERMISSIONS);
        return false;
    }
    return true;
}