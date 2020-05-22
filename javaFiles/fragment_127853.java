public void addMultiFarm(MultiFarmModel multiFarm) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
   // values.put(KEY_MULTI_FARM_ID, multiFarm.getId()); 
    values.put(KEY_MULTI_FARM_FARM_NAME, multiFarm.getFarmName());
    //Insert Record
    Log.e("StringInsertId", "" + db.insert(TABLE_MULTI_FARM, null, values));
    db.close();
}