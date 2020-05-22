public class DBHelperNoRowid extends SQLiteOpenHelper {

    public final static String DB = "test_norowid";
    public static final int VERSION = 1;
    public static final String TBL_NOROWID = "norowid";
    public static final String COL_ID = BaseColumns._ID;
    public static final String COL_MYDATA = "mydata";
    public static final String TBL_WITHROWID = "withrowid";

    SQLiteDatabase mDB;

    public DBHelperNoRowid(Context context) {
        super(context, DB, null, VERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crt_norowid_table = "CREATE TABLE IF NOT EXISTS " + TBL_NOROWID + "(" +
                COL_ID + " INTEGER PRIMARY KEY, " +
                COL_MYDATA + " TEXT" +
                ") WITHOUT ROWID";
        db.execSQL(crt_norowid_table);
        String crt_withrowid_table = "CREATE TABLE IF NOT EXISTS " + TBL_WITHROWID + "(" +
                COL_ID + " INTEGER PRIMARY KEY, " +
                COL_MYDATA + " TEXT" +
                ")";
        db.execSQL(crt_withrowid_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertUsingConvenienceInsert(long not_an_id, String text, boolean without_rowid, boolean generate_rowid) {
        ContentValues cv = new ContentValues();
        String table = TBL_WITHROWID;
        if (without_rowid) {
            table = TBL_NOROWID;
            cv.put(COL_ID,not_an_id);
        } else {
            if (generate_rowid) {
                cv.put(COL_ID,not_an_id);
            }
        }
        cv.put(COL_MYDATA,text);
        return mDB.insert(table,null,cv);
    }

    public void logLastInsertId() {
        Cursor csr = mDB.rawQuery("SELECT last_insert_rowid()",null);
        if (csr.moveToFirst()) {
            Log.d("LASTINSERTEDROWID","The Last RowID inserted was " + String.valueOf(csr.getLong(0)));
        } else {
            Log.d("LASTINSERTEDROWID","Ooops there does not appear to have been a row inserted");
        }
    }
}