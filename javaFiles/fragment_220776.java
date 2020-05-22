/**
 * Check the permission for the ACCESS_FINE_LOCATION
 * if already accepted the permission then pass true
 * else ask permission for the ACCESS_FINE_LOCATION
 *
 * @return
 */
private boolean checkAndRequestPermissions() {
    int externalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

    List<String> listPermissionsNeeded = new ArrayList<>();
    if (externalStoragePermission != PackageManager.PERMISSION_GRANTED) {
        listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    if (!listPermissionsNeeded.isEmpty()) {
        ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_PERMISSIONS);
        return false;
    }
    return true;
}