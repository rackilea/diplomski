public class DataSource extends SQLiteOpenHelper {

    protected static final String DB_NAME = "BmiCalcHistoryDatabase";
    protected static final int START_DB_VERSION = 1;

    /* columns */
    protected static final String TABLE_NAME = "CalcHistory";
    protected static final String KEY_ID = "id";
    protected static final String KEY_RESULT = "result";
    protected static final String KEY_TYPE = "type";
    protected static final String KEY_DATE = "calcDate";

    public DataSource(Context cntx) {
        super(cntx, DB_NAME, null, START_DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_RESULT + " TEXT NOT NULL, "
                + KEY_TYPE + " TEXT NOT NULL, "
                + KEY_DATE + " TEXT NOT NULL" + ");";
        db.execSQL(CREATE_QUERY);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DELETE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DELETE_QUERY);
        onCreate(db);
    }
}