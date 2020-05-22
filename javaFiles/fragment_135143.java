public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb.db";
    public static final int DBVERSION = 1;

    public static final String TB_MYTABLE = "_mytable";
    public static final String COL_MYTABLE_ID = BaseColumns._ID;
    public static final String COL_MYTABLE_NAME = "_name";

    SQLiteDatabase mDB;
    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crtsql = "CREATE TABLE IF NOT EXISTS " +TB_MYTABLE +
                "(" +
                COL_MYTABLE_ID + " INTEGER PRIMARY KEY," +
                COL_MYTABLE_NAME + " TEXT" +
                ")";
        db.execSQL(crtsql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addRow(String name) {
        ContentValues cv = new ContentValues();
        cv.put(COL_MYTABLE_NAME,name);
        return mDB.insert(TB_MYTABLE,null,cv);
    }

    public Cursor getAllRows() {
        return mDB.query(TB_MYTABLE,null,null,null,null,null,null);
    }
}