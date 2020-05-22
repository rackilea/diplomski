public Cursor selectShift (String name){
    SQLiteDatabase db = dbHandler.getReadableDatabase();
    Cursor c = db.query(TABLE_NAME, new String[] {"_id"}, "name LIKE '"+name+"%'", null, null, null, null);
    c.moveToFirst();
    db.close();
    return c;
}