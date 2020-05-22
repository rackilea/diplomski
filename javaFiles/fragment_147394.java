@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == CAMERA_REQUEST){  
        if (resultCode == Activity.RESULT_OK) {
            // Image captured and saved to fileUri specified in the Intent
        }
        else if (resultCode == Activity.RESULT_CANCELED) {
            // User cancelled the image capture
        } else {
            // Image capture failed, advise user
        }
    }