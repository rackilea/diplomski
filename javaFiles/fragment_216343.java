// 1.
File tempFile = File.createTempFile("camera", ".png", getExternalCacheDir());
mPath = tempFile.getAbsolutePath();
Uri uri = Uri.fromFile(tempFile);

// 2.
Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

// 3.
protected void onActivityResult(int requestCode, int resultCode, Intent data){
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    Bitmap bitmap = BitmapFactory.decodeFile(mPath, options);

    mImageView.setImageBitmap(bitmap);
}