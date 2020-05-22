public int getAppointmentID(String name){
    SQLiteDatabase db = getReadableDatabase();
    int i=0;
    String[] projection = {_ID};
    String selection = COLUMN_TITLE + " = ? ";
    String[] selectionArgs = new String[]{name};
    Cursor cursor = db.query(TABLE_APPOINTMENTS, projection, selection, selectionArgs, null, null, null);

    if (cursor != null) {
        cursor.moveToFirst();                      
    }

    i = cursor.getInt(0);
    cursor.close();
    db.close();

    return i;
}