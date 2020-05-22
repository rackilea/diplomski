public boolean checkIfRowPresent(String name) {
    SQLiteDatabase db = helper.getWritableDatabase();

    Cursor cursor =
            db.query(DBhelper.TABLE1, null, DBHelper.NAME + "='" + name + "'", null, null, null,
                    null, null);
    boolean ret = false;
    if (cursor.getCount() > 0) {
        ret = true; // There is a row present in table1 with the given name
    }
    db.close();

    return ret;

}