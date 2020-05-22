public ArrayList<String> getNameDB(Context context) throws SQLException {
this.con = new DatabaseHelper(context);

try {
    this.con.createDataBase();
} catch (IOException e) {
    ;
}

if (!this.con.checkDataBase()) {
    return null;
} else {
    this.con.openDataBase();
    SQLiteDatabase db = this.con.getWritableDatabase();

    for (Cursor cursor = db.rawQuery("SELECT firstName,lastName FROM tbl_doctor", (String[]) null); cursor.moveToNext(); this.firstName.add(cursor.getString(0)+" "+cursor.getString(1)) {

    }


    this.con.close();
    return this.firstName;

}

}