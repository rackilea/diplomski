/**
 * Check if the database already exists. NOTE will create the databases folder is it doesn't exist
 * @return true if it exists, false if it doesn't
 */
public static boolean checkDataBase(Context context, String dbname) {

    File db = new File(context.getDatabasePath(dbname).getPath()); //Get the file name of the database
    Log.d("DBPATH","DB Path is " + db.getPath()); //TODO remove if publish App
    if (db.exists()) return true; // If it exists then return doing nothing

    // Get the parent (directory in which the database file would be)
    File dbdir = db.getParentFile();
    // If the directory does not exits then make the directory (and higher level directories)
    if (!dbdir.exists()) {
        db.getParentFile().mkdirs();
        dbdir.mkdirs();
    }
    return false;
}