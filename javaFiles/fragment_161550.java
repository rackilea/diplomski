@Override
public void onRequestPermissionsResult(
        int requestCode,
        String permissions[],
        int[] grantResults) {
    switch (requestCode) {
        case REQUEST_PERMISSION_PHONE_STATE:
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "Permission Granted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Permission Denied!", Toast.LENGTH_SHORT).show();
            }
    }
}

private void showExplanation(String title,
                             String message,
                             final String permission,
                             final int permissionRequestCode) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    requestPermission(permission, permissionRequestCode);
                }
            });
    builder.create().show();
}

private void requestPermission(String permissionName, int permissionRequestCode) {
    ActivityCompat.requestPermissions(this,
            new String[]{permissionName}, permissionRequestCode);
}