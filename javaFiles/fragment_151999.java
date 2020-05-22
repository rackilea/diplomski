public String randomize() {
    Cursor cursor;
    cursor =  this.db.query("tblnames ORDER BY RANDOM() LIMIT 1", new String[] { "*" }, null, null, null, null, null);
    if(cursor.moveToFirst()) {
        return cursor.getString(cursor.getColumnIndexOrThrow( "word" ));
    }
    return "";
}