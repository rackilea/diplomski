public List<MyTableTwo> getMyItems() {
    List<MyTableTwo> mySuperList = new ArrayList<>();
    SQLiteDatabase db = this.getReadableDatabase();
    String selectQuery = "SELECT  * FROM " + USER_TABLE_NAME;
    Cursor c = db.rawQuery(selectQuery, null);
    if (c != null) {
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            MyTableTwo myTable = new MyTableTwo();
            myTable.itemName = (c.getString(c.getColumnIndex("Item_Name")));
            myTable.weight = (c.getString(c.getColumnIndex("Weight")));
            myTable.mrp = (c.getString(c.getColumnIndex("MRP")));
            myTable.barcod = (c.getString(c.getColumnIndex("BARCODE")));

            mySuperList.add(myTable);
            c.moveToNext();
        }
    }
    return mySuperList;
}