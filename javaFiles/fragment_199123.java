public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;
    public static final String TB_SCORE = "myscores";
    public static final String COL_SCORE = "score";
    public static final String COL_ID = BaseColumns._ID;

    public static final String DERIVEDCOL_MAXSCORE = "max_score";
    public static final String DERIVEDCOl_MINSCORE = "min_score";

    private static final String crt_myscores_sql = "CREATE TABLE IF NOT EXISTS " + TB_SCORE + "(" +
            COL_ID + " INTEGER," +
            COL_SCORE + " INTEGER" +
            ")";

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crt_myscores_sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long addScore(long id, int score) {
        ContentValues cv = new ContentValues();
        cv.put(COL_ID,id);
        cv.put(COL_SCORE,score);
        return this.getWritableDatabase().insert(TB_SCORE,null,cv);
    }

    public Cursor getMaxMinScores() {
        String sum_score = "sum_score";
        String cte1 = "cte1";
        String rawqry = " WITH " + cte1 +
                " AS " +
                "(" +
                "SELECT sum(" +
                COL_SCORE +
                ") AS " + sum_score +
                " FROM " + TB_SCORE + " GROUP BY " + COL_ID +
                ") " +
                "SELECT " +
                " max(" +
                sum_score +
                ") AS " + DERIVEDCOL_MAXSCORE +
                "," +
                " min(" +
                sum_score +
                ") AS " + DERIVEDCOl_MINSCORE +
                " FROM " + cte1 + ";";
        return this.getWritableDatabase().rawQuery(rawqry,null);
    }

    public MaxMin getMaxAndMinScores() {
        MaxMin rv = new MaxMin(0,0);
        Cursor csr = getMaxMinScores();
        if (csr.moveToFirst()) {
            rv.setMin(csr.getInt(csr.getColumnIndex(DERIVEDCOl_MINSCORE)));
            rv.setMax(csr.getInt(csr.getColumnIndex(DERIVEDCOL_MAXSCORE)));
        }
        csr.close();
        return rv;
    }
}