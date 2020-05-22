public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydatabase";
    public static final int DBVERSION = 1;

    private static SQLiteDatabase mDB;

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CompanyDB.getTableCreateSQL());
        db.execSQL(ContactDB.getTableCreatSQL());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}