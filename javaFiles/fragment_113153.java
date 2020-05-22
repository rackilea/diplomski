dataBase = mHelper.getWritableDatabase();
 mCursor = dataBase.rawQuery("SELECT * FROM "
        + DBHelper.TABLE_NAME + " WHERE " + DBHelper.KEY_COUNT
        + " IS NOT NULL AND " + DBHelper.KEY_COUNT + " != '0'", null);
product_price.clear();
productprice = 0;

JSONObject Root = new JSONObject();
JSONArray productArray = new JSONArray();

if (mCursor.moveToFirst()) {
    do {
        JSONObject product = new JSONObject();
        /*
        product_price.add(mCursor.getString(mCursor
                .getColumnIndex(DBHelper.KEY_PRODUCT_TOTAL_PRICE)));
        product_name.add(mCursor.getString(mCursor
                .getColumnIndex(DBHelper.KEY_PNAME)));
        product_quantity.add(mCursor.getString(mCursor
                .getColumnIndex(DBHelper.KEY_COUNT)));*/

        product.put("product_name", mCursor.getString(mCursor
                .getColumnIndex(DBHelper.KEY_PRODUCT_TOTAL_PRICE)));

        product.put("product_total", mCursor.getString(mCursor
                .getColumnIndex(DBHelper.KEY_PNAME)));

        product.put("product_quantity", mCursor.getString(mCursor
                .getColumnIndex(DBHelper.KEY_COUNT)));

        productArray.put(contact);        



    } while (mCursor.moveToNext());

      Root.put( productArray);
}