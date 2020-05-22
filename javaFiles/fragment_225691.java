public int get_points(String pseudo) {
    int rv = -1;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery("Select points from user where 
    pseudo=?",new String[]{pseudo});
    if (cursor.moveToFirst()) {
        rv = cursor.getInt(cursor.getColumnIndex("points"));
    }
    cursor.close();
    return rv;   
}