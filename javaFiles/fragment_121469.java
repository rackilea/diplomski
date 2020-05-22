@Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        // if the result is capturing Image
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK ) {
                // successfully captured the image
                //Log.d("ucrop", "error log" + fileUri);
                // performUcrop();
                //final Uri fileUri = UCrop.getOutput(data);
                performcrop();
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == CAMERA_CAPTURE_VIDEO_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // video successfully recorded
                //launching upload activity
                launchUploadActivity(false);
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled recording
                Toast.makeText(getApplicationContext(), "Sorry! Failed to record video", Toast.LENGTH_SHORT).show();
            }
        }
        else if (requestCode == UCrop.REQUEST_CROP) {
            if(resultCode == RESULT_OK) {
                fileUri=UCrop.getOutput(data);
                launchUploadActivity(true);
            }
            else if(resultCode == UCrop.RESULT_ERROR) {

            }
        }
    }