/**
 * Utility: Return the storage directory.  Create it if necessary.
 */
public static File dataDir()
{
    File sdcard = Environment.getExternalStorageDirectory();
    if( sdcard == null || !sdcard.isDirectory() ) {
        // TODO: warning popup
        Log.w(TAG, "Storage card not found " + sdcard);
        return null;
    }
    File datadir = new File(sdcard, "MyApplication");
    if( !confirmDir(datadir) ) {
        // TODO: warning popup
        Log.w(TAG, "Unable to create " + datadir);
        return null;
    }
    return datadir;
}


/**
 * Create dir if necessary, return true on success
 */
public static final boolean confirmDir(File dir) {
    if( dir.isDirectory() ) return true;
    if( dir.exists() ) return false;
    return dir.mkdirs();
}