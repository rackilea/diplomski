public void saveImage(Bitmap b)
{
    String path = Environment.getExternalStorageDirectory().toString();
    OutputStream fOut = null;

    File file = new File(path, "XXXXXXXXXXX.jpg");
    Log.d("saveImage", "File to save: " + file.getAbsolutePath());

    try {
        FileOutputStream fOut = new FileOutputStream(file);
    }
    catch(FileNotFoundException e) {
        Log.d("saveImage", "Couldn't open file: " + e.getMessage());
    }

    if(fOut != null) {
        b.compress(Bitmap.CompressFormat.JPEG, 85, fOut);
        fOut.flush();
        fOut.close();
        MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
    }
}