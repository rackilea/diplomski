private static final int PERMISSION_REQUEST_CODE = 1;

 if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

    if (checkSelfPermission(Manifest.permission.SEND_SMS)
            == PackageManager.PERMISSION_DENIED) {

        Log.d("permission", "permission denied to SEND_SMS - requesting it");
        String[] permissions = {Manifest.permission.SEND_SMS};

        requestPermissions(permissions, PERMISSION_REQUEST_CODE);

    }
}