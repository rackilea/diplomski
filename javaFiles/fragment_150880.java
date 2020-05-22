public Uri getLocalBitmapUri(Context context, Bitmap bmp, String id) {
    Uri bmpUri = null;
    try {
        if (id == null) {
            id = String.valueOf(System.currentTimeMillis());

        }
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + id + ".png");
        FileOutputStream out = new FileOutputStream(file);
        bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
        out.close();
        bmpUri = Uri.fromFile(file);
    } catch (Exception e) {
        Log.e(TAG, "getLocalBitmapUri: ", e);
    }
    return bmpUri;
}