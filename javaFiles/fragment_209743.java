@Override
public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
  switch(oldVersion) {
    case 1:
      //add new column
      sqLiteDatabase.execSQL("ALTER TABLE "+ TABLE_NAME + " ADD COLUMN "+ NEW_COLUMN + " INTEGER/TEXT ");
  }
}