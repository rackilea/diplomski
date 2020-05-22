private final int REQUEST_CAMERA_USAGE = 200;

if (Build.VERSION.SDK_INT >= 21) {
            int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_USAGE);
            } else {

            }
        }



 @Override
public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    switch (requestCode) {
            case REQUEST_CAMERA_USAGE:
            if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

            } else {
                Toast.makeText(getApplicationContext(), "This Permission is needed for the app to work perfectly!", Toast.LENGTH_SHORT).show();
            }
        default:
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            break;
    }
}