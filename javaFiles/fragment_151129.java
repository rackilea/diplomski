/**
 * Database Helper that includes ability to open database from assets
 * if the database doesn't exist.
 * (i.e. a pre-defined database)
 *
 */

public class OpenAssetDBHelper extends SQLiteOpenHelper {

    private static final String LOGTAG = "OADB-HLPR";
    public static final int MAXIMUM_HELPERS = 10;
    private String mDBPath, mAssetPath;
    private static OpenAssetDBHelper mInstance[] = new OpenAssetDBHelper[MAXIMUM_HELPERS];
    private SQLiteDatabase mDB;

    /**
     * OpenAssetDBHelper Class that will copy a predefined database
     * from the assets folder and then open it is the database;
     *
     * The copy will only be done if the database does not exist.
     *
     * Note this code is intended to be used for development and/or
     * experimentation, hence the extensive logging.
     */

    /**
     * get an OpenAssetDBHelper instance as a singleton;
     * Note! caters for up to 10 OpenAssetDBHelpers for up to 10 databases
     * as specified by the helper_index
     *
     * @param helper_index  Index to this instance/database
     *                      (0-MAXIMUM_HELPERS less 1)
     * @param context       Context for the database
     * @param database      Database name (i.e. file name)
     * @param dbversion     Database version (user_version)
     * @param assetfile     Name of the asset file to be copied to the database
     * @param asset_sub_directories String Array of the sub-directories where
     *                              the asset file is located;
     *                              MUST be in order
     * @return              The resultant OpenAssetDBHelper
     */
    public static synchronized OpenAssetDBHelper getInstance(
            int helper_index,
            Context context,
            String database,
            int dbversion,
            String assetfile,
            String[] asset_sub_directories) {
        // Checck that helper_index is within bounds
        if (helper_index > (MAXIMUM_HELPERS -1)) {
            throw new RuntimeException(
                    "Helper Index greater than " +
                            MAXIMUM_HELPERS
            );
        }
        if (helper_index < 0) {
            throw new RuntimeException(
                    "Helper Index cannot be negative, must be 0-" +
                            MAXIMUM_HELPERS
            );
        }
        // Create the respective OpenAssetDBHelper instance
        if(mInstance[helper_index] == null) {
            mInstance[helper_index] = new OpenAssetDBHelper(context,
                    database,
                    dbversion,
                    assetfile,
                    asset_sub_directories);
        }
        return mInstance[helper_index];
    }

    /**
     * Construct an OpenAssetDBHelper instance;
     * Note! can only be called within class
     *
     * @param context       the context to be used
     * @param database      the database name (equates to filename)
     * @param dbversion     the databaae version (user_version)
     * @param assetfile     The name of the asset file i.e. the pre-defined db
     * @param directories   The hierarchy of directories within the assets folder
     *                      where the asset file is located
     *                      (null or zero elements = in the assets folder)
     */
    private OpenAssetDBHelper(Context context,
                              String database,
                              int dbversion,
                              String assetfile,
                              String[] directories) {
        super(context, database, null, dbversion);
        Log.d(LOGTAG,"OpenAssetDBHelper being constructed.");

        mDBPath = context.getDatabasePath(database).getPath();
        if (assetfile == null || assetfile.length() < 1) {
            assetfile = database;
        }
        mAssetPath = buildAssetPath(directories,assetfile);

        if (!ifDatabaseExists(mDBPath)) {
            Log.d(LOGTAG,"Database " + database + " not found at " + mDBPath + " so attempting to copy from assets.");
            if (copyDatabaseFromAssets(context,mDBPath, database, mAssetPath)) {
                Log.d(LOGTAG, "Successfully Copied Database from Assets.");
            } else {
                throw new RuntimeException("No Database Available.");
            }
        }
        // Force Database open and store it
        this.mDB = this.getWritableDatabase();
        logDatabaseTableInformation(mDB);
        Log.d(LOGTAG,"OpenAssetDBHelper constructed.");
    }


    /**
     * onCreate - This is where you would create tables;
     * Typically this is where you would alter the structure of the database;
     * Note that this is called once for the lifetime of the database.
     * @param db The SQLitedatabase
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOGTAG,new Object(){}.getClass().getEnclosingMethod().getName() + " initiated.");
        // As Database is copied from assets nothing to do in onCreate!
        Log.d(LOGTAG,new Object(){}.getClass().getEnclosingMethod().getName() + " completed.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(LOGTAG,new Object(){}.getClass().getEnclosingMethod().getName() + " initiated.");
        // Nothing to do as it's early days in the Database's lifetime.
        Log.d(LOGTAG,new Object(){}.getClass().getEnclosingMethod().getName() + " completed.");
    }

    /**
     * Check to see if the Database exists,
     * if it doesn't exists then check to see if
     * the database directory exists,
     * if the directory(ies) does(do) not exist then make the directory(ies);
     *
     *
     * @param dbpath        The path to the database
     * @return              true if the database exists, else false
     */
    private boolean ifDatabaseExists(String dbpath) {
        Log.d(LOGTAG,new Object(){}.getClass().getEnclosingMethod().getName() + " initiated.");
        File db = new File(dbpath);
        if(db.exists()) return true;
        File dir = new File(db.getParent());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return false;
    }

    /**
     * Copy the Database from the assets folder
     * @param context
     * @param dbpath
     * @return
     */
    private boolean copyDatabaseFromAssets(Context context,String dbpath, String dbname, String asset) {
        String thisclass = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d(LOGTAG,thisclass + " initiated");
        InputStream assetsdb;
        OutputStream database;
        File db = new File(dbpath);
        int filesize;
        // Get the asset file
        try {
            Log.d(LOGTAG,thisclass + " attempting to find asset " + asset);
            assetsdb = context.getAssets().open(asset);
            filesize = assetsdb.available();
            Log.d(LOGTAG,thisclass + " asset " + asset +
                    " located successfully with a size of " +
                    Integer.toString(filesize)
            );
        } catch (IOException e) {
            Log.d(LOGTAG,thisclass + " Did not locate asset " + asset);
            e.printStackTrace();
            return false;
        }

        // Read the first 16 bytes from the asset file
        byte[] dbcheck = new byte[16];
        try {
            assetsdb.read(dbcheck,0,16);
        } catch (IOException e) {
            Log.d(LOGTAG, thisclass + " failed trying to read 16 bytes to check for a valid database. ");
            e.printStackTrace();
            return false;
        }

        // Check that the asset file is an SQLite database
        String chkdb = new String(dbcheck);
        if(!chkdb.equals("SQLite format 3\u0000")) {
            Log.d(LOGTAG,thisclass + " asset " +
                    asset +
                    " is not a valid SQLite Database File (found " +
                    chkdb +
                    " at bytes 1-16 instead of SQLite format 3)");
            try {
                assetsdb.close();
            } catch (IOException e) {
                // Not worth doing anything
            }
            return false;
        }
        // Close the asset file
        try {
            assetsdb.close();
        } catch (IOException e) {
            Log.d(LOGTAG,thisclass +
                    " failed to close assets file after checking for a valid database."
            );
            return false;
        }
        // Re-open the asset file
        try {
            assetsdb = context.getAssets().open(asset);
            filesize = assetsdb.available();
        } catch (IOException e) {
            Log.d(LOGTAG, thisclass +
                    " failed trying to re-open asset " +
                    asset +
                    " after checking for a valid database."
            );
            e.printStackTrace();
            return false;
        }

        // Read the entire asset file into a buffer
        Log.d(LOGTAG, thisclass +
                " copying asset database " +
                dbname +
                " into buffer of size " +
                filesize
        );
        byte[] buffer = new byte[filesize];
        // Close the asset file
        try {
            assetsdb.read(buffer);
            Log.d(LOGTAG,thisclass +
                    " closing asset database " + dbname
            );
            assetsdb.close();
        } catch (IOException e) {
            Log.d(LOGTAG, thisclass +
                    " failed while copying asset database " +
                    dbname +
                    " (or closing asset database)."
            );
            e.printStackTrace();
            return false;
        }
        // Open the new database file
        try {
            Log.d(LOGTAG,thisclass + " attempting to open new database file " + dbpath);
            database = new FileOutputStream(dbpath);
        } catch (IOException e) {
            Log.d(LOGTAG, thisclass + " failed to open new database file.");
            e.printStackTrace();
            return false;
        }
        // Write the new database file
        try {
            Log.d(LOGTAG, thisclass + " writing new database file " + dbpath);
            database.write(buffer);
        } catch (IOException e) {
            Log.d(LOGTAG, thisclass + " failed while writing new database file " + dbpath);
            e.printStackTrace();
            return false;
        }
        // Flush the new database file
        try {
            Log.d(LOGTAG, thisclass + " flushing new database file " + dbpath);
            database.flush();
        } catch (IOException e) {
            Log.d(LOGTAG, thisclass + " failed while flushing new database file " + dbpath);
            e.printStackTrace();
            return false;
        }
        // Close the new database file
        try {
            Log.d(LOGTAG, thisclass + " closing new database file " + dbpath);
            database.close();
        } catch (IOException e) {
            Log.d(LOGTAG, thisclass + " failed while closing new database file " + dbpath);
            e.printStackTrace();
            return  false;
        }
        Log.d(LOGTAG,new Object(){}.getClass().getEnclosingMethod().getName() + " completed.");
        return true;
    }

    /**
     * Log Database table Information
     */
    private void logDatabaseTableInformation(SQLiteDatabase db) {
        Log.d(LOGTAG,new Object(){}.getClass().getEnclosingMethod().getName() + " initiated.");
        String mastertable = "sqlite_master";
        String typecolumn = "type";
        String namecolumn = "name";
        String sqlcolumn = "sql";
        String[] args = new String[]{"table","android_metadata"};
        Cursor csr = db.query(mastertable,
                null,
                typecolumn + "=? AND " + namecolumn + "!=?",
                 args,
                null,null,null
        );
        while (csr.moveToNext()) {
            Log.d(LOGTAG,"Database contains Table " +
                    csr.getString(csr.getColumnIndex(namecolumn)) +
                    " created by SQL " +
                    csr.getString(csr.getColumnIndex(sqlcolumn))
            );
            logTableInformation(db, csr.getString(csr.getColumnIndex(namecolumn)));
        }
        csr.close();
        Log.d(LOGTAG,new Object(){}.getClass().getEnclosingMethod().getName() + " completed.");
    }

    /**
     * Write Table information, Table name, Column Count,
     * Row Count and Column Names to the Log
     * @param table Name of the table to be reported on
     */
    private void logTableInformation(SQLiteDatabase db, String table) {
        Cursor csr = db.query(table,
                null,
                null,
                null,
                null,
                null,
                null
        );
        Log.d(LOGTAG,"Table is " +
                table +
                " Column Count = " +
                Integer.toString(csr.getColumnCount()) +
                " Row Count = " +
                Long.toString(DatabaseUtils.queryNumEntries(mDB,table))
        );
        StringBuilder columns_as_string = new StringBuilder();
        for (String s: csr.getColumnNames()) {
            columns_as_string.append(s).append(" ");
        }
        Log.d(LOGTAG, "\tColumns are :- " + columns_as_string);
        csr.close();
    }

    /**
     * Build the sub-path to the asset, according to the directories specified
     *
     * @param directories   directories underneath the assets folder where
     *                      the asset files is located, null or empty
     *                      array if file is located directly in the
     *                      assets folder;
     *                      directories must be specified in the order
     *                      in which they appear in the path.
     * @param filename      The filename of the asset
     * @return              The fill sub-path to the asset
     */
    private String buildAssetPath(String[] directories, String filename) {
        StringBuilder sb = new StringBuilder();
        final String SEPERATOR = "/";
        if (directories != null && directories.length > 0) {
            for (String s: directories) {
                sb.append(s);
                if (!s.substring(s.length()-1,s.length()).equals(SEPERATOR)) {
                    sb.append(SEPERATOR);
                }
            }
            sb.append(filename);
            return sb.toString();
        } else {
            return filename;
        }
    }
}