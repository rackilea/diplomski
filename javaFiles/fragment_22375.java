@Override
public void onCreate(SQLiteDatabase db) {
    String SQL_String = "CREATE TABLE " + TABLE_NAME + "("
            + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_2 + " TEXT, "
            + COL_3 + " VARCHAR(20), "