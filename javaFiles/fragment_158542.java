@Override
protected void onPostResume() {
    super.onPostResume();
    if (sentToSettings) {
        if (ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[0]) == PackageManager.PERMISSION_GRANTED) {
            //Got Permission
            proceedAfterPermission();
        }else {
            getPermission();
        }
    }
}