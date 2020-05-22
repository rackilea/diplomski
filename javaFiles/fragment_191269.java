public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_EVENTS = "events";
    private static final String COLUMN_SEID = BaseColumns._ID; //<<<<<<<<<< suits Cursor Adaptor
    private static final String COLUMN_SNAME = "sname";
    private static final String COLUMN_STYPE = "stype";
    private static final String COLUMN_SDATE = "sdate";
    private static final String COLUMN_EDATE = "edate";
    private static final String COLUMN_STIME = "stime";
    private static final String COLUMN_ETIME = "etime";
    private static final String COLUMN_VENUE = "venue";
    private static final String COLUMN_DESC = "desccription";
    private static final String COLUMN_SCID = "scid";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_ACOST = "acost";
    private static final String COLUMN_INV = "inv";
    private static final String COLUMN_PCOST = "pcost";
    private static final String COLUMN_FOOD = "food";
    private static final String COLUMN_TINC = "tinc";
    private static final String COLUMN_DIST = "dist";
    private static final String COLUMN_TCOST = "tcost";

    public static final String TABLE_SCOUTS = "scouts"; //<<<<<<<<<<< public so the can be used elsewhere
    public static final String COLUMN_FNAME = "fname";
    public static final String COLUMN_LNAME = "lname";
    public static final String COLUMN_SECTION = "section";

    SQLiteDatabase mDB;

    private static final String CREATE_TABLE_EVENTS=("CREATE TABLE " + TABLE_EVENTS + "("
            + COLUMN_SEID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SNAME + " TEXT,"
            + COLUMN_STYPE + " TEXT,"+ COLUMN_SDATE + " TEXT," + COLUMN_EDATE + " TEXT,"
            + COLUMN_STIME + " TEXT," + COLUMN_ETIME + " TEXT," + COLUMN_VENUE + " TEXT,"
            + COLUMN_DESC + " TEXT," + COLUMN_SCID + " INTEGER," + COLUMN_EMAIL + " TEXT,"
            + COLUMN_ACOST + " REAL," + COLUMN_INV + " INTEGER," + COLUMN_PCOST + " REAL,"
            + COLUMN_FOOD + " TEXT," + COLUMN_TINC + " TEXT," + COLUMN_DIST + " INTEGER,"
            + COLUMN_TCOST + " REAL )");

    private static final String CREATE_TABLE_SCOUTS = "CREATE TABLE " + TABLE_SCOUTS + "(" +
            COLUMN_SCID + " INTEGER PRIMARY KEY," +
            COLUMN_FNAME + " TEXT," +
            COLUMN_LNAME + " TEXT," +
            COLUMN_SECTION + " TEXT" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EVENTS);
        db.execSQL(CREATE_TABLE_SCOUTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long addScout(String fname, String lname, String section) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FNAME,fname);
        cv.put(COLUMN_LNAME,lname);
        cv.put(COLUMN_SECTION,section);
        return mDB.insert(TABLE_SCOUTS,null,cv);
    }

    public Cursor getLeaders() {
        String where_clause = COLUMN_SECTION + "=?";
        String[] where_args =  new String[]{"Leaders"};
        //<<<<<<<<<< NOTE SELECT scid AS _id, fname, lname, section so that the id column in the cursor is _id
        String[] columns = new String[]{COLUMN_SCID + " AS " + BaseColumns._ID,COLUMN_FNAME, COLUMN_LNAME,COLUMN_SECTION};
        return mDB.query(TABLE_SCOUTS,columns,where_clause,where_args,null,null,null);
    }
}