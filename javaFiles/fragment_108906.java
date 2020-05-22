public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DataBaseHelper";

    // Database Name
    private static final String DATABASE_NAME = "MYAPP";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USER = "user_info";

    // Common column names TABLE_USER
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "u_name";
    private static final String KEY_PASSWORD = "u_pwd";

    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS " + TABLE_USER
            + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_USERNAME + " TEXT,"
            + KEY_PASSWORD + " TEXT"
            + ")";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed

        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_USER);
        // Create tables again
        onCreate(db);
    }
}