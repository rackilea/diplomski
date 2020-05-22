//Create a dbHelper class like this

public class DatabaseNew extends SQLiteOpenHelper {
    private static final String TAG = "DataBase";

    public DatabaseNew(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Module1";
    private static final String USERTABLE = "USER_INFO";
    private static final String KEY_ID = "id";
    private static final String WORKOUT = "WORKOUT";
    private static final String WORKOUT_TIME = "WORKOUT_TIME";

    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS "
            + USERTABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY," + WORKOUT + " TEXT,"
            + WORKOUT_TIME + " TEXT"+");";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + USERTABLE;

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG,"Inside onCreate: creating table");
        db.execSQL(CREATE_TABLE_USER);
    }

    //to save workout name and time in db
    public void saveData(String workout, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(WORKOUT,workout);
        data.put(WORKOUT_TIME,time);
        db.insert(USERTABLE,null,data);
        db.close();
    }

    //to get workout name and time from db
    public List<HashMap<String,String>> getData(){
        List<HashMap<String,String>> userData = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + USERTABLE ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String,String> dataMap = new HashMap<>();
                dataMap.put(WORKOUT,cursor.getString(cursor.getColumnIndex(WORKOUT)));
                dataMap.put(WORKOUT_TIME,cursor.getString(cursor.getColumnIndex(WORKOUT_TIME)));
                userData.add(dataMap);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userData;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG,"Inside onUpgrade");
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}