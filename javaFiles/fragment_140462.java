public void deleteAll(View view) {
    DatabaseOperations helper = new DatabaseOperations(this);
    SQLiteDatabase db = helper.getWritableDatabase();
    db.execSQL("DELETE FROM " + TableData.TableInfo.TABLE_NAME);
    db.close();
}