@Override
public void onCreate(SQLiteDatabase sqLiteDatabase) {
    final String SQL_CREATE_BLABLA_TABLE = "CREATE TABLE " + "TableNameHere" + " (" +
            "_id" + " INTEGER PRIMARY KEY," +
           "name" + " TEXT NOT NULL);";

    sqLiteDatabase.execSQL(SQL_CREATE_BLABLA_TABLE);
 }