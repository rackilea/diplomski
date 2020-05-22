public String getRows(long id) {
     // TODO Auto-generated method stub
    String[] columns = new String[]{KEY_ROWID,KEY_CONTACT,KEY_PHONE,KEY_DAYS};
    Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + id, null, null, null, null);
    c.moveToFirst();  // <---- add this
    String value = c.getString(1) + "\n" + c.getString(2) + "\n" + c.getString(3); 
    return value;
}