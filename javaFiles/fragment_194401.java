public class DbHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "lyrics.db";
    private SQLiteDatabase vDatabase;
    private Context vContext;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.vContext = context;
        // Copy the DB if need be when instantiating the DbHelper
        if (!checkDataBase()) {
            copyDB();
        }
        vDatabase = this.getWritableDatabase(); //Get the database when instantiating
    }

    /**
     * No need for build version check as getDataBasePath works for all versions
     * No need for open and close of Database, just open it once for the lifetime (more efficient)
     */

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {
        /**
         * Does not open the database instead checks to see if the file exists
         * also creates the databases directory if it does not exists
         * (the real reason why the database is opened, which appears to result in issues)
         */
        File db = new File(vContext.getDatabasePath(DB_NAME).getPath()); //Get the file name of the database
        Log.d("DBPATH","DB Path is " + db.getPath());
        if (db.exists()) return true; // If it exists then return doing nothing

        // Get the parent (directory in which the database file would be)
        File dbdir = db.getParentFile();
        // If the directory does not exist then make the directory (and higher level directories)
        if (!dbdir.exists()) {
            db.getParentFile().mkdirs();
            dbdir.mkdirs();
        }
        return false;
    }

    public void copyDB() throws SQLiteException{
        try {
            InputStream myInput = vContext.getAssets().open(DB_NAME);
            String outputFileName = vContext.getDatabasePath(DB_NAME).getPath(); //<<<<<<<<<< changed
            Log.d("LIFECYCLE", outputFileName);
            OutputStream myOutput = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;
            while( (length=myInput.read(buffer)) > 0 ){
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    public List<Lyric> getAllSong(){
        List<Lyric> temp = new ArrayList<>();
        Cursor cursor = vDatabase.query("lyrics",null,null,null,null,null,null);
        //Cursor cursor = db.rawQuery( "SELECT * FROM lyrics" , null); // used query method generally preferred to rawQuery
        //if( cursor == null) return null; // Cursor will not be null may be empty
        //cursor.moveToFirst(); // changed to use simpler loop
        while (cursor.moveToNext()) {
            Lyric lyric = new Lyric(
                    //cursor.getString(cursor.getColumnIndex("index")), //<<<<<<< changed due to column name change
                    cursor.getString(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("song")),
                    cursor.getString(cursor.getColumnIndex("year")),
                    cursor.getString(cursor.getColumnIndex("artist")),
                    cursor.getString(cursor.getColumnIndex("genre")),
                    cursor.getString(cursor.getColumnIndex("lyrics"))
            );
            temp.add(lyric);
        }
        cursor.close();
        //db.close(); // inefficient to keep on opening and closing db
        return temp;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}