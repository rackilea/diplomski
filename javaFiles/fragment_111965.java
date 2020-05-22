SQLiteOpenHelper dummy = new SQLiteOpenHelper(this, "mobileAppBeginner.db", null, 1) {
        @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
        @Override public void onCreate(SQLiteDatabase db) {}
    };

    SQLiteDatabase db = dummy.getWritableDatabase();
    db.execSQL("CREATE TEMP TABLE messages (read_status INTEGER, direction INTEGER, target TEXT)");
    db.execSQL("CREATE TEMP TABLE IF NOT EXISTS tt1 (unread_message int, target varchar)");
    db.execSQL("INSERT INTO tt1 SELECT count(*), target  FROM messages where read_status=0 and direction=1 GROUP BY target");