public int countItems(Integer product_id, Integer user_id) {
    SQLiteDatabase db = this.getReadableDatabase();
    String query = "SELECT COUNT(product_query) FROM " + TABLE_CART + " WHERE product_id=? AND user_id=?";
    String[] whereValues = new String[] {String.valueOf(product_id), String.valueOf(user_id)};
    return DatabaseUtils.longForQuery(db, query, whereValues);
}