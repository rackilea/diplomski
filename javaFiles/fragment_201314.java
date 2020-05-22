public class DatabaseHelper extends SQLiteOpenHelper {

    Context c;

    public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, 1);
    c = context;
    }

@Override
public void onCreate(SQLiteDatabase db) {

    db.execSQL("Create table " + TABLE_USERS +" (UserID INTEGER PRIMARY KEY AUTOINCREMENT, Forename TEXT, Surname TEXT, Email TEXT, Password TEXT, Country TEXT)");
db.execSQL("Create table " + TABLE_CAPACITY +" (CapacityID INTEGER PRIMARY KEY AUTOINCREMENT, Capacity INTEGER)");
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAPACITY);
onCreate(db);
}

public void sampleMethod(String[] arguments) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("Column1", arguments[0]);
    values.put("Column2", arguments[1]);
    values.put("Column3", arguments[2]);
    ....
    db.insert(TABLE_NAME, null, values);
    db.close();
}