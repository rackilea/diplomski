private File getOutputMediaFile() {
    File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "Lion");
    if (!mediaStorageDir.exists()) {
        if (!mediaStorageDir.mkdirs()) {
            Log.d("Lion", "failed to create Dir");
            return null;
        }
    }
    timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
    File mediaFile;
    mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_ " + timeStamp + ".jpg");
    TempImg = mediaFile.toString();

    return mediaFile;
}