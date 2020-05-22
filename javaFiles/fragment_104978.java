public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "newpdil3.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table pdil(id INTEGER PRIMARY KEY AUTOINCREMENT, tiang text null, lat text null, long text null, area text null, rayon text null, jenis text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    public void insertData(String tiang, String lat, String long, String jenis) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("tiang", tiang);
        values.put("lat", lat);
        values.put("long", long);
        values.put("jenis", jenis);

        // Insert data 
        db.insert("pdil", null, values);
    }

    .................
    ........................
}