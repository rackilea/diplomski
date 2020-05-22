@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    // If you need to add a column
    if (newVersion > oldVersion) {
        db.execSQL("ALTER TABLE foo ADD COLUMN new_column INTEGER DEFAULT 0");
    }
}