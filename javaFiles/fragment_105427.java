public String checkUser(String email) {
    String result = "";
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor res = db.rawQuery(
        "SELECT TYPEOFUSER from user_table WHERE EMAIL = ?", 
        new String[] {email}
    );
    if (res.moveToNext()) {
        result = res.getString(0);
    }
    res.close();
    return result;
}