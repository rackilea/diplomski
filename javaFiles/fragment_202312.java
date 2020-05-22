// Once a file has been created, use this method to publicize
//the file as it can be seen !!
// But be sure to add "Context context;" outside of the method.
// Plus, remember to add "context = getApplicationContext ();" in the 
//onCreate () method.

public void scanFile(String path) {

    MediaScannerConnection.scanFile(context,
            new String[] { path }, null,
            new MediaScannerConnection.OnScanCompletedListener() {

                public void onScanCompleted(String path, Uri uri) {
                    Log.i("TAG", "Finished scanning " + path);
                }
            });
}