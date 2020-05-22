@Override
public void onRequestPermissionsResult(int requestCode,
    String permissions[], int[] grantResults) {
    if(requestCode == REQUEST_ID_MULTIPLE_PERMISSIONS && grantResults.length == listPermissionsNeeded.size()){
        boolean allGranted = true;
        for(int grantedResult : grantedResults){
            if(grantedResult != PackageManager.PERMISSION_GRANTED){
                allGranted = false;
            }
        }
        if(allGranted){
            attemptLogin();
        }
    }
}