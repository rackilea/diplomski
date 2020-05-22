public Cursor user_id(){
    SQLiteDatabase db = getReadableDatabase();
    String query = "SELECT user_id FROM OrderDetails";
    Cursor c = db.rawQuery(query, null);
    return c;
}