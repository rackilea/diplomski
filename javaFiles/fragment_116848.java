public class DBHelperNoRowid extends SQLiteOpenHelper {

    public final static String DB = "test_norowid";
    public static final int VERSION = 1;
    public static final String TBL_NOROWID = "norowid";
    public static final String COL_ID = BaseColumns._ID;
    public static final String COL_MYDATA = "mydata";

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
                ") WITHOUT ROWID"; //<<<<<<<<<<
        db.execSQL(crt_norowid_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertUsingConvenienceInsert(long not_an_id, String text) {
        ContentValues cv = new ContentValues();
        cv.put(COL_ID,not_an_id);
        cv.put(COL_MYDATA,text);
        return mDB.insert(TBL_NOROWID,null,cv);
    }
}