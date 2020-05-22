public class DbManager extends SQLiteOpenHelper {

    private static final String DB_NAME = "BHCLibrary3.sqlite";
    private static final String DB_PATH = "/data/data/gr.BHC.www/databases/";
    private static final Integer DB_VERSION = 1;
    private static final String TAG = "DbManager";
    private final Context context;
    private SQLiteDatabase db;
    private DbManager dbManager;

    public DbManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE 'notes' (_id integer primary key autoincrement, title text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public DbManager open() {
        dbManager = new DbManager(context);
        db = dbManager.getWritableDatabase();
        return this;
    }

    public void createNewDatabase() {
        InputStream assetsDB = null;
        try {
            assetsDB = context.getAssets().open(DB_NAME);
            OutputStream dbOut = new FileOutputStream(DB_PATH + DB_NAME);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = assetsDB.read(buffer)) > 0) {
                dbOut.write(buffer, 0, length);
            }

            dbOut.flush();
            dbOut.close();
            assetsDB.close();
            Log.i(TAG, "New database created...");
        } catch (IOException e) {
            Log.e(TAG, "Could not create new database...");
            e.printStackTrace();
        }
    }

    public Cursor rawQ(String select) {
        return db.rawQuery(select, null);
    }
}