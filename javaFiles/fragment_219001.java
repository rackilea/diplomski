public double getTotalPrice() {
    String sql = "select sum(" + KEY_QUANTITY + " * " + KEY_PRICE + ") from "
             + DATABASE_TABLE;
    Cursor cursor = db.rawQuery(sql, null);
    if (cursor.moveToFirst()) {
        return cursor.getDouble(0);
    }
    return 0;
}