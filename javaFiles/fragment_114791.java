public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_HOUR + " TEXT NOT NULL, " +
            KEY_DAY + " TEXT NOT NULL, " +
            KEY_LOCATION + " TEXT NOT NULL, " +
            KEY_SUBJECT + " TEXT NOT NULL, " +
            KEY_START + " TEXT NOT NULL, " +
            KEY_END + " TEXT NOT NULL, " +
            "UNIQUE (" + KEY_DAY + ", " + KEY_HOUR + ") ON CONFLICT ROLLBACK);"
    );