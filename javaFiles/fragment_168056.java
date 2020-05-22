private void startCropImageActivity(Uri imageUri)
{
    File file = null;
    try
    {
        file = createImageFile();
        Uri mUri = FileProvider.getUriForFile(this,
                CAPTURE_IMAGE_FILE_PROVIDER, file);
        CropImage.activity(imageUri)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setMultiTouchEnabled(true)
                .setAllowFlipping(false)
                .setAspectRatio(1, 1)
                .setRequestedSize(350, 350)
                .setMinCropResultSize(350, 350)
                .setMaxCropResultSize(800, 800)
                .setOutputCompressFormat(Bitmap.CompressFormat.PNG)
                .setOutputCompressQuality(90)
                .setOutputUri(mUri)
                .start(this);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
}

    private File createImageFile() throws IOException
{

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "MYAPPNAME-" + timeStamp + ".jpg";
    File mediaStorageDir = new File(Environment.getExternalStorageDirectory(),
            "YourAppFolder");
    File storageDir = new File(mediaStorageDir + "/Profile_Images");
    if (!storageDir.exists())
    {
        storageDir.mkdirs();
    }
    File image = new File(storageDir, imageFileName);
    return image;
}