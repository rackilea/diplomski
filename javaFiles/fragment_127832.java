public String databaseToString() {
    String dbString = "";
    SQLiteDatabase db = getWritableDatabase();
    String query = "SELECT * FROM " + TABLE_USERS + " WHERE 1";

    // Cursor point to a location in your results
    Cursor c = db.rawQuery(query, null);
    // Move to the first row in your results
    //check that moveToFirst returns true
    if (c.moveToFirst()){

      while(!c.isAfterLast()) {
        if(c.getString(c.getColumnIndex("username")) != null) {
            dbString += c.getString(c.getColumnIndex("username"));
            dbString += "\n";
        }
        c.moveToNext(); //added
      }

    }
    c.close(); //added
    db.close();
    return dbString;
}