// The request code used in ActivityCompat.requestPermissions()
// and returned in the Activity's onRequestPermissionsResult()
int PERMISSION_ALL = 1; 
String[] PERMISSIONS = {
  android.Manifest.permission.READ_CONTACTS, 
  android.Manifest.permission.WRITE_CONTACTS, 
  android.Manifest.permission.WRITE_EXTERNAL_STORAGE, 
  android.Manifest.permission.READ_SMS, 
  android.Manifest.permission.CAMERA
};

if (!hasPermissions(this, PERMISSIONS)) {
    ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
}