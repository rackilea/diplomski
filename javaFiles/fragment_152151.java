public String getFromDb(String tableName, String select, String selectBy, String selectName){
    String selection = "Error";
    Cursor c = mDb.query(tableName, new String[] {select}, selectBy + "=" + selectName, null, null, null, null);
    if(c.getCount() == 1){
        c.moveToFirst();
        selection = c.getString(c.getColumnIndex(select));
    }
    c.close();
    mDb.close();
    Log.d("FootballApp", select + "=" + selection);
    return id;      
}