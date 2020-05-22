public ArrayList<HashMap<String, String>> getChannelDetails(){
ArrayList<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
    String selectQuery = "SELECT  * FROM " + TABLE_CHANNEL;

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            HashMap<String,String> channels = new HashMap<String,String>();

            channels.put("title", cursor.getString(1));
            channels.put("url", cursor.getString(2));
            channels.put("create_at", cursor.getString(3));
            list.add(channels);
        } while (cursor.moveToNext());
        Log.d("Count", Integer.toString(cursor.getCount()));
    }

    cursor.close();
    db.close();
    // return channels
    return list;
}