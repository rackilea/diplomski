// Tell the media scanner about the new file so that it is
// immediately available to the user.
MediaScannerConnection.scanFile(this,
    new String[] { filename }, null,
    new MediaScannerConnection.OnScanCompletedListener() {
    public void onScanCompleted(String path, Uri uri) {
    Log.i("ExternalStorage", "Scanned " + path + ":");
        Log.i("ExternalStorage", "-> uri=" + uri);
    }
});