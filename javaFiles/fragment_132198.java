protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
        Log.v("MainActivity", "Result successful.");
    } else if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_CANCELED) {
        Log.v(TAG, "Result canceled. Uri of file is " + mCurrentPhotoPath);
        File file = new File(mCurrentPhotoPath);
        if (file.exists()) {
            Log.v(TAG, "File exists.");
            if(file.delete()) {
                 Log.v(TAG, "File was successfully deleted!");
            } else {
                 Log.v(TAG, "File not successfully deleted.");
            }
        } else {
            Log.v(TAG, "File does not exist!");
        }


    }
}