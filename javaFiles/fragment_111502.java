public String getDevName(String devid) {
    db = myDBHelper.getWritableDatabase();  //get db if not done so already, you may have already done this in code not shown

    String name = null;
    String where = KEY_DEVID + " like ?";
    String[] selectionArgs =  new String[] {"%"+ devid + "%" };
    Cursor c =  db.query(true, DATABASE_TABLE, ALL_KEYS, 
                    where, selectionArgs , null, null, null, null);

    //Only use cursor if moveToFirst() succeeds
    //this will make it so that you don't get the CursorIndexOutOfBoundsException
    if (c.moveToFirst()){
        name = c.getString(COL_DEVICE);
    }

    c.close(); //close your cursor to avoid memory leak!

    db.close(); //close here if you call getWritableDatabase() in beginning of this function

    //This will return null if no results from query
    return name;
}