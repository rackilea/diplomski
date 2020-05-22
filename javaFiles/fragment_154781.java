File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyAppDir");

if (!mediaStorageDir.exists()) {
    if (!mediaStorageDir.mkdirs()) {
        Log.e(TAG, "failed to create directory");
        return null;
    }
}

String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
File mediaFile;
mediaFile = new File(mediaStorageDir.getPath() + File.separator + "testimage_" + timeStamp + ".png");