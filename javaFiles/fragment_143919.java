public class dietclass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "diet7.db";
    public static final String TABLE_NAME = "Cal_val";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM";
    public static final String COL3 = "QUANTITY";
    public static final String COL4 = "CALORIES";
    //private static String DB_PATH = "/data/data/com.example.janhvik.dietapp/databases/";
    //private static String DB_NAME = "diet7.db";
    SQLiteDatabase myDataBase;


    private Context myContext;

    public dietclass(Context context) {
        super(context,DATABASE_NAME,null,1);
        myDataBase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,ITEM TEXT,QUANTITY VARCHAR,CALORIES INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public long insertCal_ValEntry(String item, String quantity, int calories) {
        ContentValues cv = new ContentValues();
        cv.put(COL2,item);
        cv.put(COL3,quantity);
        cv.put(COL4,calories);
        return myDataBase.insert(TABLE_NAME,null,cv);
    }


    public String databaseToString(String item_name) {

        //String myDbPath;
        int cal = 0 ;
        String add="";
        //myDbPath = DB_PATH+DB_NAME;
        //myDataBase = SQLiteDatabase.openOrCreateDatabase(myDbPath, null);

        String query = "SELECT * FROM "+TABLE_NAME+" WHERE ITEM='"+item_name+"'";
        Cursor c = myDataBase.rawQuery(query,null);

        if(c.moveToFirst()){
            add = c.getString(c.getColumnIndex("CALORIES"));
            c.close();
        }
        add = add + " calories";
        //Toast.makeText(ctx,add, Toast.LENGTH_LONG).show();
        return add;
    }
}