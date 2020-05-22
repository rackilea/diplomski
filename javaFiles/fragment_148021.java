public static Bitmap base64ToBitmap(String strBase64) throws IOException {
    byte[] bitmapdata = Base64.decode(strBase64);
    Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0,
            bitmapdata.length);
    return bitmap;
}