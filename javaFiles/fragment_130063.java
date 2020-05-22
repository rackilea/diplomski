public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_PATH = Environment.getExternalStorageDirectory().getAbsoluteFile()+ "/MYFOLDER/";
    private static final String DATABASE_NAME = "TheWorld.db";
    private static final int DATABASE_VERSION = 1;

    MyDatabaseHelper(Context context) {
        super(context, DATABASE_PATH+DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CountriesDb.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        CountriesDb.onUpgrade(db, oldVersion, newVersion);
    }
}