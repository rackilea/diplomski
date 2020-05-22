/**
 * Called when returning from the camera request.
 */
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
        Log.d(TAG, "Received camera activity result");
        if (resultCode == RESULT_OK) {
            String resultPath = "";
            if (data == null) {
                if (this.newPhotoUri != null) {
                    Log.d(TAG, "Intent data is null, trying with uri " + this.newPhotoUri.getPath());
                    resultPath = this.newPhotoUri.getPath();
                } else {
                    Log.d(TAG, "Intent data and photo Uri are null, exiting");
                    return;
                }
            } else {
                // Image captured and saved to fileUri specified in the Intent
                Log.d(TAG, "Image saved to: " + data.getData());
                resultPath = data.getData().toString();
            }
            // process resultPath
        } else if (resultCode == RESULT_CANCELED) {
            // User cancelled the image capture
            Log.d(TAG, "User cancelled");
        } else {
            // Image capture failed
        }
    }
}