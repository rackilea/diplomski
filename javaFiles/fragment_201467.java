public Cursor getAllRows(String TABLE_NAME, String sql){
    String selectQuery = "SELECT * FROM " + TABLE_NAME + " " + sql;

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    if(cursor != null){
        cursor.moveToFirst();
    }
    return cursor;
}