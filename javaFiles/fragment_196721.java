private static final String SQL_DELETE_TABLES =
        "DROP TABLE IF EXISTS " + TABLE_STUDENTS;

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(SQL_DELETE_TABLES); // drop table if exists

    onCreate(db);
}