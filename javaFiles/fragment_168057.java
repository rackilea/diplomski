@SuppressLint("NewApi")
protected void onActivityResult(int requestCode, int resultCode, Intent data)
{

    // handle result of pick image chooser
    if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK)
    {
        Uri imageUri = CropImage.getPickImageResultUri(this, data);

        // For API >= 23 we need to check specifically that we have permissions to read external storage.
        if (CropImage.isReadExternalStoragePermissionsRequired(this, imageUri))
        {
            // request permissions and handle the result in onRequestPermissionsResult()
            mCropImageUri = imageUri;
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
        else
        {
            // no permissions required or already grunted, can start crop image activity
            startCropImageActivity(imageUri);
        }
    }

    // handle result of CropImageActivity
    if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE)
    {
        CropImage.ActivityResult result = CropImage.getActivityResult(data);
        if (resultCode == RESULT_OK)
        {
            profileImageFilepath = result.getUri().getPath();
            Log.d("cropImageUri", result.getUri().getPath());
            new PostDataAsyncTask().execute();
            Toast.makeText(this, "Photo Selected Successfully", Toast.LENGTH_LONG).show();
        }
        else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE)
        {
            Toast.makeText(this, "Photo Selection Failed", Toast.LENGTH_SHORT).show();
        }
    }
}