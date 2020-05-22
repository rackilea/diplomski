public void addLineStation(SQLiteDatabase db, LineStation lineStation)  {
    ContentValues values = new ContentValues();

    values.put(/*...*/);
    /* ... */

    db.insert(DatabaseHandler.TABLE_LINE_STATION, null, values); // database is no longer locked (code 5)
}