public boolean login(String name , String password){
    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE NAME=? AND PASSWORD=?", new String[] {name , password});
    int count = cursor.getCount();
    cursor.close();
    return count > 0;
}