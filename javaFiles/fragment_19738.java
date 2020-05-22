private File getOutputFromCamera() {

    File storageDir = new File(
            Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
            AppConstants.FOLDER_NAME);
    if (!storageDir.exists()) {
        if (!storageDir.mkdirs()) {
            Log.i(TAG, "Failed to create directory " + storageDir
                    + AppConstants.FOLDER_NAME);
            Toast.makeText(this, "Failed to create Directory",
                    Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
            Locale.getDefault()).format(new Date());
    File imageFile = new File(storageDir.getPath() + File.separator
            + "IMG_" + timeStamp + ".png");
    return imageFile;
}