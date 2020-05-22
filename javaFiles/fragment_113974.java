public void saveImageToExternalStorage(Bitmap image) {
    //image=scaleCenterCrop(image,200,200);
    String fullPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/";
    try
    {
        File dir = new File(fullPath);
        if (!dir.exists()) {
        dir.mkdirs();
        }
        OutputStream fOut = null;
        File file = new File(fullPath, "photo.png");

        if(file.exists())
            file.delete();

        file.createNewFile();
        fOut = new FileOutputStream(file);
        // 100 means no compression, the lower you go, the stronger the compression
        image.compress(Bitmap.CompressFormat.PNG, 100, fOut);
        fOut.flush();
        fOut.close();
    }
    catch (Exception e)
    {
        Log.e("saveToExternalStorage()", e.getMessage());
    }
}