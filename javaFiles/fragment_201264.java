@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
    db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLEAPP);
    onCreate(db);
}