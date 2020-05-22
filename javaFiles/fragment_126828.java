.......
...............

private static final String COL_2 = "Favourite";

DBHelper(Context context) {
    super(context, DATABASE_NAME, null, 3);
}

@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, Favourite TEXT)");
}

........
..................