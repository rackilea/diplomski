private File storeImageExternalMemory(String dirName, String mediaName) {
    String packageName = mContext.getPackageName();
    File mediaStorageDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
            + "/Android/data/" + packageName + dirName);

    if (!mediaStorageDir.exists()) {
        if (!mediaStorageDir.mkdirs()) {
            return null;
        }
    }
    File mediaFile;
    mediaFile = new File(mediaStorageDir.getPath(), mediaName + ".jpeg");
    return mediaFile;
}

/* Checks if external storage is available for read and write */
public boolean isExternalStorageWritable() {
    String state = Environment.getExternalStorageState();
    return Environment.MEDIA_MOUNTED.equals(state);
}

/* Checks if external storage is available to at least read */
public boolean isExternalStorageReadable() {
    String state = Environment.getExternalStorageState();
    return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
}