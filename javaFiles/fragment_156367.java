String mImagePath = extras.getString("image-path");
  Bitmap mBitmap = getBitmap(mImagePath);
   private Uri getImageUri(String path) {
return Uri.fromFile(new File(path));
}

private Bitmap getBitmap(String path) {
Uri uri = getImageUri(path);
InputStream in = null;
try {
    in = mContentResolver.openInputStream(uri);
    return BitmapFactory.decodeStream(in);
} catch (FileNotFoundException e) {
    Log.e(TAG, "file " + path + " not found");
}
return null;
}