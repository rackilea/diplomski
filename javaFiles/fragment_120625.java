public void getCameraPermission(){
    if (!checkPermission()) {
        requestPermission();
    }
}

private boolean checkPermission(){
    int result = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);

    if (result == PackageManager.PERMISSION_GRANTED){
        return true;
    } else {
        return false;
    }
}

private void requestPermission(){
    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)){

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
    } else {

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
    }
}

@Override
public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    switch (requestCode) {
        case PERMISSION_REQUEST_CODE:
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
              Toast.makeText(MainActivity.this,"Permission granted",Toast.LENGTH_SHORT).show();
                //store permission in shared pref

            }

            else {
                Toast.makeText(MainActivity.this,"Permission denied",Toast.LENGTH_SHORT).show();
                //store permission in shared pref
            }
            break;
    }
}