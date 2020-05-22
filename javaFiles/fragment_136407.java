//Add a new row to the database
public void addProduct(Product product, Product productdate){
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(COLUMN_PRODUCTNAME, product.get_productname());
    values.put(COLUMN_PRODUCTNAME_DATE, productdate.get_productnamedate());
    db.insert(KICK_TABLE, null, values);
    db.close();
}