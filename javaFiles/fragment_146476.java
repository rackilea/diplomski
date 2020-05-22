public static File savebitmap(Bitmap bmp) throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    bmp.compress(Bitmap.CompressFormat.JPEG, 60, bytes);
    File f = new File(Environment.getExternalStorageDirectory()
            + File.separator + "testimage.jpg");
    f.createNewFile();
    FileOutputStream fo = new FileOutputStream(f);
    fo.write(bytes.toByteArray());
    fo.close();
    return f;
}