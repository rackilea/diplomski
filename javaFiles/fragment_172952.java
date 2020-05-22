/**
 * Add data to the table
 *
 * @param item
 * @return
 */
public boolean addData(String item) {

    String[] splitdata = item.split(","); //<<<<<<<<<< split the input string
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();

    boolean result = true;
    db.beginTransaction(); //<<<<<<<<<< prepare to do in a single transaction
    // Loop through each string inserting an entry into the database
    for (String s : splitdata) {
        contentValues.clear(); //<<<<<<<<<< clear any existing values to be safe
        contentValues.put(COL2, s);
        if (db.insert(TABLE_NAME, null, contentValues) < 1) {
            result = false;
        }
    }
    if (result) {
        db.setTransactionSuccessful(); //<<<<<<<<<< only set the transaction successful if all inserts worked
    }
    db.endTransaction();
    return result;
}