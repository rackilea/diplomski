@Override
public void onCreate(SQLiteDatabase sqLiteDatabase) {
  Log.d(TAG, "onCreate: Creating dbs");
  sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "   +   TABLE_LIVE);
  sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "   +   TABLE_VISIT);

  createVisitTable(sqLiteDatabase);
  createLiveTable(sqLiteDatabase);

  Log.d(TAG, "onCreate: db created");
}