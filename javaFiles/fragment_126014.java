public void saveImageToFile(Bitmap bmp) {
    String fn = "sent_image";
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    bmp.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
    FileOutputStream fo = openFileOutput(fn, Context.MODE_PRIVATE);
    fo.write(bytes.toByteArray());
    fo.close();
}