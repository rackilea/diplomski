public void deleteValue(String value)
    {
         SQLiteDatabase db = getWritableDatabase();

         String whereClause = "name"+"=?";
         String[]whereArgs = new String[] {String.valueOf(value)};
          db.delete(TABLE_NAME, whereClause, whereArgs);
          db.close();
          Log.v("done","deleted  row ");
    }