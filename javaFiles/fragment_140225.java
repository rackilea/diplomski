byte[] byteArray = intent.getByteArrayExtra("myImage");

Bitmap myImage = convertCompressedByteArrayToBitmap(byteArray);

Bitmap convertCompressedByteArrayToBitmap(byte[] src) {
    return BitmapFactory.decodeByteArray(src, 0, src.length);
}