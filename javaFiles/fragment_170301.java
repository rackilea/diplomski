private void askPermissions(boolean isForOpen) {
    isRationale = false;
    List permissionsRequired = new ArrayList();

    final List<String> permissionsList = new ArrayList<String>();
    if (!checkPermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE))
        permissionsRequired.add("Write External Storage");
    if (!checkPermission(permissionsList, Manifest.permission.CALL_PHONE))
        permissionsRequired.add("Call phone");
    if (!checkPermission(permissionsList, Manifest.permission.READ_PHONE_STATE))
        permissionsRequired.add("Read phone state");
    if (!checkPermission(permissionsList, Manifest.permission.READ_CONTACTS))
        permissionsRequired.add("Read Contacts");
    if (!checkPermission(permissionsList, Manifest.permission.RECEIVE_SMS))
        permissionsRequired.add("Receive SMS");
    if (!checkPermission(permissionsList, Manifest.permission.GET_ACCOUNTS))
        permissionsRequired.add("Get Accounts");
    if (!checkPermission(permissionsList, Manifest.permission.ACCESS_COARSE_LOCATION))
        permissionsRequired.add("Location");
    if (!checkPermission(permissionsList, Manifest.permission.ACCESS_FINE_LOCATION))
        permissionsRequired.add("Location");

    if (permissionsList.size() > 0 && !isRationale) {
        if (permissionsRequired.size() > 0) {

        }
        if (isForOpen) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ActivityCompat.requestPermissions(this, permissionsList.toArray(new String[permissionsList.size()]),
                        11);
            }
        }

    } else if (isRationale) {
        if (isForOpen) {

            new android.support.v7.app.AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle)
                    .setTitle("Permission Alert")
                    .setMessage("You need to grant permissions manually. Go to permission and grant all permissions.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", getPackageName(), null);
                            intent.setData(uri);
                            startActivityForResult(intent, 123);
                        }
                    })
                    .show();
        }
    } else {
        startActivity(new Intent(PermissionsActivity.this, SplashActivity.class));
        finish();
    }
}

private boolean checkPermission(List permissionsList, String permission) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!isFirst) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                    isRationale = true;
                    return false;
                }
            }
        }
    }
    return true;
}