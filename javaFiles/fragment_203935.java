Bitmap bm=null;
if (data != null) {
    try {
        bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
if (bm != null) { // sanity check
    File outputDir = context.getCacheDir(); // Activity context
    File outputFile = File.createTempFile("image", "jpg", outputDir); // follow the API for createTempFile

    FileOutputStream stream = new FileOutputStream (outputFile, false); // Add false here so we don't append an image to another image. That would be weird.
    // This line actually writes a bitmap to the stream. If you use a ByteArrayOutputStream, you end up with a byte array. If you use a FileOutputStream, you end up with a file.
    bm.compress(Bitmap.CompressFormat.JPEG, 100, stream); 
    stream.close(); // cleanup
}