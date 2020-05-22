public void dispatchTakePhotoIntent(int actionCode) {
    if (actionCode == 100) {
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePhotoIntent, actionCode);
    }
  }