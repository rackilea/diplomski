// Getting All data
public List<ItemDetails> getAllItemDetails() {
List<ItemDetails> listAll = new ArrayList<ItemDetails>();
// Select All Query
String selectQuery = "SELECT  * FROM " + ORDER_TABLE;

SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
if (cursor.moveToFirst()) {
    do {

        ItemDetails operatorTable = new ItemDetails();
        //here get all data from cursor and set it into setter method like below
       operatorTable.set_orderId(Integer.parseInt(cursor.getString(0)));
        //operatorTable.set_Operator(cursor.getString(1));

        operatorList.add(operatorTable);
    } while (cursor.moveToNext());
}

// returnlist
return listAll ;