/** This method returns all the items found on the table of the database,
 * recurses the table and returns a list of items
 * */
public List<Item> getAllItems() {
    List<Item> items = new ArrayList<>();
    //String selectQuery = "SELECT * FROM " + TABLE_NAME; //<<<<<<<<<< COMMENTED OUT not needed as query method builds the SQL
    SQLiteDatabase db = this.getReadableDatabase();
    //Cursor cursor = db.rawQuery(selectQuery, null);
    // Generally recommended to use the query Convenience method rate than rawQuery
    Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);

    // No Need to do multiple checks for the same i.e. moveTo will return false if the move cannot be made
    //  if no rows then moveToNext returns false so loop ended
    //  if at last row then moveToNext will return false thus loop ended
    while (cursor.moveToNext()) {
                // Rather than hard coding offsets (which could change over time)
                // better to get the offset according to the column name
                String itemName = cursor.getString(cursor.getColumnIndex(COL_PRODUCTNAME));
                double initialP = cursor.getDouble( cursor.getColumnIndex(COL_INITIALPRICE));
                double currentP = cursor.getDouble(cursor.getColumnIndex(COL_CURRENTPRICE));
                double priceC = cursor.getDouble(cursor.getColumnIndex(COL_PRICECHANGE));
                String itemUrl = cursor.getString(cursor.getColumnIndex(COL_ITEMWEBPAGE));
                //Item holder = new Item(itemName, initialP, currentP, priceC, itemUrl); // No need for intermediate Item
                items.add(new Item(itemName, initialP, currentP, priceC, itemUrl)); //<<<<<<<<<< CHANGED
    }
    return items;
}