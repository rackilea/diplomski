if (!checkPermission(readPermission) || !checkPermission(writePermission)) {
        requestPermission(new String[] {readPermission,writePermission});        
  } else{
    //Run Async task directly since the permissions are already granted
  }



private void requestPermission(String[] permissions){
    if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])||ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[1])){
        Toast.makeText(getApplicationContext(), "Read/Write external storage permission allows us to read/write data. Please allow in App Settings for additional functionality.",Toast.LENGTH_LONG).show();
    }
    ActivityCompat.requestPermissions(this, permissions,PERMISSION_REQUEST_CODE);
}