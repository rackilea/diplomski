public boolean update(String tripid, String title, String description, String location){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(COL_2, title);
    contentValues.put(COL_3, description);
    contentValues.put(COL_5, location);
    return db.update(TABLE_NAME,contentValues, COL_1 + " = ?", new String[]{tripid}) > 0;
}