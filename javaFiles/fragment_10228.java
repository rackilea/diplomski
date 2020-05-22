@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == Activity.RESULT_OK) {
      if (requestCode == SELECT_CAMERA_IMAGE_REQUEST
                && resultCode == Activity.RESULT_OK) {
            picfile = mFileTemp;
            postFlagFileCheck = 1;
            bitmap_postImage = BitmapFactory.decodeFile(picfile
                    .getAbsolutePath());
            setImagePreview(bitmap_postImage);
        }
  }