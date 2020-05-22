@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    if (oldVersion == 1 && newVersion == 2) {
        db.execSQL(CREATE_TABLE_ITEMS);
    }
}