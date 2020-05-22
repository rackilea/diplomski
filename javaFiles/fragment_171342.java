public  boolean checkDuplicate(String name) {
  String Query = ""; // your query
  Cursor cursor = db.rawQuery(Query, null);
      if(cursor.getCount() <= 0){
      cursor.close();
      return false;
     }
      cursor.close();
      return true;
  }

 public void insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        db.insert(TABLE_NAME,null ,contentValues);
    }