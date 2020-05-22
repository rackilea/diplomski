public void onCreate(SQLiteDatabase db) {

    String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_TASKS + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_TASKNAME
            + " TEXT, " + KEY_STATUS + " INTEGER)";
    db.execSQL(sql);
}