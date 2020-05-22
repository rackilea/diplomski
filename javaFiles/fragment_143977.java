public int getCount() {
    String countQuery = "SELECT  * FROM " + DatabaseHandler.TABLE_NAME;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(countQuery, null);

    int count = cursor.getCount();
    cursor.close();

    // return count
    return count;
}