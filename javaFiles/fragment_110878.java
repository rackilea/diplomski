public void saveImage(Bitmap b)
{
    String path = Environment.getExternalStorageDirectory().toString();
    OutputStream fOut = null;

    File file = new File(path, "XXXXXXXXXXX.jpg");
    fOut = new FileOutputStream(file);

    b.compress(Bitmap.CompressFormat.JPEG, 85, fOut);
    fOut.flush();
    fOut.close();
    MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
}