public Cursor fetchAllEvents() {

    SQLiteDatabase db = this.getWritableDatabase();
    String[] columns = new String[]{"*","strftime('%d'," + COL_DATE + " / 1000,'unixepoch') AS date_as_DD"}; //<<<<<<<<<< this gets the day of the month DD from the timestamp
    return db.query(TABLE_NAME,columns,null,null,null,null,null);
}