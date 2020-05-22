public int GetTotal(){
    int temp;
    SQLiteDatabase db = getWritableDatabase();
    String[] columns = new String[]{"SELECT SUM(" + COLUMN_PRODUCTCOST + ")"}
    Cursor cursor = db.query(TABLE_PRODUCTS,columns,null,null,null,null,null);
    if (cursor.moveToFirst()) {
        temp = cursor.getInt(0);
    }
    else temp = 0; //<<<<<<<<<< CHANGED not to return as the Cursor would not be closed.
    cursor.close();
    return temp;
}