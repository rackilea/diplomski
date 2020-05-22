public Cursor totaldistance(){
    String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.DSNM, DatabaseHelper.SDATE };
    Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, DatabaseHelper._ID + " DESC limit 5");
    if (cursor != null) {
        // Here you are pointing to the first row of the cursor
        // you need to add this row content into your list  
        cursor.moveToFirst();
    }
    return cursor;
}