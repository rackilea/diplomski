SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.example.abc2/databases/DB_BusData", null, 0);
Cursor c = db.rawQuery("SELECT * FROM Tbl_Driver", null);
if(c.moveToFirst()) {
    String username = c.getString(0).trim();
    String password = c.getString(1).trim();
    //Log.d(username, "try");
}
db.close();