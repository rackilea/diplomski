public class DBAdapter {
    public static final String KEY_ROWID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DUEDATE = "duedate";
    public static final String KEY_COURSE = "course";
    // public static final String KEY_NOTES = "notes";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "billsdb";
    private static final String DATABASE_TABLE = "bills";
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE =
            "create table if not exists assignments (id integer primary key autoincrement, "
                    + "title VARCHAR not null, duedate date, course VARCHAR );";

    // Replaces DATABASE_CREATE using the one source definition
    private static final String TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + "(" +
                    KEY_ROWID + " INTEGER PRIMARY KEY, " + // AUTOINCREMENT NOT REQD
                    KEY_TITLE + " DATE NOT NULL, " +
                    KEY_DUEDATE + " DATE ," +
                    KEY_COURSE + " VARCHAR " +
                    ")";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(TABLE_CREATE); // NO need to encapsulate in try clause
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts"); //????????
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    //---opens the database---
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }

    //---insert a record into the database---
    public long insertRecord(String title, String duedate, String course)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TITLE, title);
        initialValues.put(KEY_DUEDATE, duedate);
        initialValues.put(KEY_COURSE, course);
        //return db.insert(DATABASE_TABLE, null, initialValues);
        // Will return NULL POINTER EXCEPTION as db isn't set
        // Replaces commented out line
        return DBHelper.getWritableDatabase().insert(DATABASE_TABLE,
                null,
                initialValues
        );
    }

    //---deletes a particular record---
    public boolean deleteContact(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //---retrieves all the records--- SEE FOLLOWING METHOD
    public Cursor getAllRecords()
    {SQLiteDatabase db = DBHelper.getWritableDatabase();
        String query ="SELECT * FROM " + DATABASE_TABLE;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    //As per getAllRecords but using query convenience method
    public Cursor getAllAsCursor() {
        return DBHelper.getWritableDatabase().query(
                DATABASE_TABLE,
                null,null,null,null,null,null
        );
    }

    //---retrieves a particular record--- THIS WILL NOT WORK - NO SUCH TABLE
    public Cursor getRecord()
    {String query1 ="SELECT * FROM" + KEY_TITLE;
        Cursor mCursor = db.rawQuery(query1,null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    // Retrieve a row (single) according to id
    public Cursor getRecordById(long id) {
        return DBHelper.getWritableDatabase().query(
                DATABASE_TABLE,
                null,
                KEY_ROWID + "=?",
                new String[]{String.valueOf(id)},
                null,null,null
                );
    }


    //---updates a record---
    public boolean updateRecord(long rowId, String title, String duedate, String course)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_TITLE, title);
        args.put(KEY_DUEDATE, duedate);
        args.put(KEY_COURSE, course);
        String whereclause = KEY_ROWID + "=?";
        String[] whereargs = new String[]{String.valueOf(rowId)};
        // Will return NULL POINTER EXCEPTION as db isn't set
        //return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
        // Replaces commented out line
        return DBHelper.getWritableDatabase().update(DATABASE_TABLE,
                args,
                whereclause,
                whereargs
        ) > 0;
    }
}