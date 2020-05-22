public void delete(String del) {
    SQLiteDatabase dataBase = mHelper.getWritableDatabase();
    String[] whereArgs = new String[] { del };
    dataBase.delete(
        DbHelper.TABLE_NAME,
        DbHelper.KEY_FNAME + "=?",
        whereArgs);
    mHelper.close();
}