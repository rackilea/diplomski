/** SQL insert statement */
private void addIP(String string) {
    SQLiteDatabase db = sql.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(IP_DB, string);
    values.put(TIME, System.currentTimeMillis());
    db.insert(TABLE_NAME, null, values);
}