public class CrimeDBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "crimesdb";
    public static final int DBVERSION = 1;
    public static final String CRIMESTABLE = "crimes";
    public static final String CRIMEID_COL = "_id";
    public static final String CRIMETITLE_COL = "crimetitle";
    public static final String CRIMEDATE_COL = "crimedate";
    public static final String CRIMESUSPECT_COL = "crimesuspect";
    public static final String CRIMESOLVED_COL = "crimesolved";


    public static final String TABLECRTSQL =
            "CREATE TABLE " + CRIMESTABLE + "(" +
                    CRIMEID_COL + " INTEGER PRIMARY KEY," +
                    CRIMETITLE_COL + " TEXT," +
                    CRIMEDATE_COL + " TEXT, " +
                    CRIMESUSPECT_COL + " TEXT, " +
                    CRIMESOLVED_COL + " INTEGER" +
                    ");";

    public CrimeDBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLECRTSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
    }

    public long addCrime(String crimetitle, String crimedate, String crimesuspect, int crimesolved) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(CRIMETITLE_COL,crimetitle);
        cv.put(CRIMEDATE_COL,crimedate);
        cv.put(CRIMESUSPECT_COL,crimesuspect);
        cv.put(CRIMESOLVED_COL,crimesolved);
        return db.insert(CRIMESTABLE,null,cv);
    }

    public int deleteCrime(long crimeid) {
        SQLiteDatabase db = getWritableDatabase();
        String whereclause = CRIMEID_COL + "=?";
        String[] whereargs = {Long.toString(crimeid)};
        return db.delete(CRIMESTABLE,whereclause,whereargs);
    }

    public Cursor getCrimeList() {
        SQLiteDatabase db = getWritableDatabase();
        return db.query(CRIMESTABLE,null,null,null,null,null,null,null);
    }
}