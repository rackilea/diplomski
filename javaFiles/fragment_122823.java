Book getentry(String value,String columnName) {

SQLiteDatabase db = this.getReadableDatabase();

Cursor cursor = db.query(TABLE_AppData, new String[] { K_ID,
        K_AUTHOR K_TITLE }, columnName + "=?",
        new String[] { value }, null, null, null, );
if (cursor != null)
    cursor.moveToFirst();

Book entry = new Book(Integer.parseInt(cursor.getString(0)),
        cursor.getString(1), cursor.getString(2));

return entry;