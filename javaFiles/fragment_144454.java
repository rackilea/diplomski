public class VocabDatabase extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    //private static String DB_PATH = ""; //<<<< RMVD
    private static String DB_PATH_ALT; //<<<< ADDED
    private static String DB_NAME = "ztr.db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     *
     * @param context
     */
    public VocabDatabase(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
        //this.DB_PATH = context.getApplicationInfo().dataDir + "/databases/"; //<<<< RMVD
        this.DB_PATH_ALT = context.getDatabasePath(DB_NAME).getPath(); //<<<< ADDED

    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     */
    public void createDataBase() throws IOException {

        //boolean dbExist = checkDataBase();  //<<<< RMVD 
        boolean dbExist = checkDataBaseAlt(); //<<<< CHANGED
        if (dbExist) {
            //do nothing - database already exist
        } else {
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getWritableDatabase();

            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }
    //<<<< ADDED Alternative method checks the file rather than database
    //<<<<       as such no open error 14 messages
    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBaseAlt() {
        //File chkdb = new File(myContext.getDatabasePath(DB_NAME).getPath()); //<<<< RMVD
        File chkdb = new File(DB_PATH_ALT); //<<<< ADDED
        return chkdb.exists();
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {
        this.getReadableDatabase();
        SQLiteDatabase checkDB = null;
        try {
            //String myPath = DB_PATH; //<<<< RMVD so no open error 14 uses alt method
            checkDB = SQLiteDatabase.openDatabase(
                    DB_PATH_ALT, //<<<< CHANGED
                    null, 
                    SQLiteDatabase.OPEN_READWRITE
            ); 

        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null; //<<<< simplified
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     */
    private void copyDataBase() throws IOException {

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME); //<<<< CHANGED

        // Path to the just created empty db
        //String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(DB_PATH_ALT); //<<<< CHANGED

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {
        //Open the database
        //String myPath = DB_PATH; //<<<< RMVD
        myDataBase = SQLiteDatabase.openDatabase(
                DB_PATH_ALT, //<<<< CHANGED
                null, 
                SQLiteDatabase.OPEN_READWRITE
        );

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            try {
                copyDataBase();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

// Add your public helper methods to access and get content from the database.
// You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
// to you to create adapters for your views.

//add your public methods for insert, get, delete and update data in database.

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public long insert(String table, String nullColumnHack, ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert(table, nullColumnHack, contentValues);
    }

    public Cursor rawQuery(String string, String[] selectionArguments) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery(string, selectionArguments);
    }
}