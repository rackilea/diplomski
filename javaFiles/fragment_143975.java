public void insertData(String contactName, String phoneNumber) {

    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();

    values.put(DatabaseHelper.Contact_Name, contactName);
    values.put(DatabaseHelper.Phone_Number, phoneNumber);

    db.insert(DatabaseHelper.TABLE_NAME, null, values);

    // close db connection
    db.close();

}