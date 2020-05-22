public List<Appo> getAllData() {
    List<Appo> appos = new ArrayList<Appo>();
    // Select All Query
    String selectQuery = "SELECT  * FROM " + APPOINTMENT_TABLE_NAME;

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            Appo appo = new Appo();
            appo.setTital(cursor.getString(0));
            appo.setTime(cursor.getString(1));
            appo.setDetails(cursor.getString(2));
            appo.setday(cursor.getString(3));

            //Adding contact to list
            appos.add(appo);
        } while (cursor.moveToNext());
    }
    // return all list
    return appos;
}