public File saveResourceImageToExternalStorage(Activity activity, String picFileName, int imageId)
{
    Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), imageId);
    File picFile = null;
    OutputStream os = null;
    try
    {
        picFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), picFileName);

        picFile.createNewFile();

        os = new FileOutputStream(picFile);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    return file;
}