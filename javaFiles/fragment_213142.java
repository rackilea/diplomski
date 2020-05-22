public String getColumnUserId(String email) {
    String rv = "";
    String[] columns = {COLUMN_USER_ID};
    String selection = COLUMN_USER_EMAIL + "=?";
    String[] selectionArgs = {email};
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.query(TABLE_USER,columns,selection,selectionArgs,null,null,null);
    if (cursor.moveToFirst()) {
        rv = cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID));
    }
    cursor.close();
    db.close();
    return rv;
}