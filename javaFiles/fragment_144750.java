@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
        case ACTION_LOCATION_SETTING:
            if (resultCode == Activity.RESULT_OK) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
                    //DO FANCY STUFF WITH LOCATION
                }
            }
            break;
        default:
            super.onActivityResult(requestCode, resultCode, data);
    }
}