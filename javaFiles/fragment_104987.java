private static final RC_CROP = 100;
private static final RC_CROP1 = 200;

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK)  // resultCode: -1
    {
        if (requestCode == CAMERA_REQUEST_CODE) // requestCode: 288
        {
            Uri picUri = pictureUri;
            startCropImageActivity(picUri, RC_CROP);
            Toast.makeText(MainActivity.this, "Image 1 save",
                    Toast.LENGTH_SHORT).show();
        }
        if (requestCode == CAMERA_REQUEST_CODE1) {
            Uri picUri = pictureUri;
            startCropImageActivity(picUri, RC_CROP1);
            Toast.makeText(MainActivity.this, "Image 2 save",
                    Toast.LENGTH_SHORT).show();
        }

        if (requestCode == RC_CROP) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            //put image on first ImageView
        }

        if (requestCode == RC_CROP1) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            //put image on second ImageView
        }

    } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
        // if there is any error show it
        Exception error = result.getError();
        Toast.makeText(this, "" + error, Toast.LENGTH_LONG).show();
    }
}


private void startCropImageActivity(Uri imageUri, int requestCode) {
    Intent vCropIntent = CropImage.activity(imageUri)
            .setGuidelines(CropImageView.Guidelines.ON)
            .setMultiTouchEnabled(true)
            .getIntent(this);

    startActivityForResult(vCropIntent, requestCode)
}