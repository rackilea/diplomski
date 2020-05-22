public static Bitmap decodeSampledBitmap(File file, int reqWidth, int reqHeight) throws FileNotFoundException {

    final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    options.inPreferredConfig = Bitmap.Config.RGB_565;

    BitmapFactory.decodeStream(new FileInputStream(file), null, options);

    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeStream(new FileInputStream(file), null, options);
}