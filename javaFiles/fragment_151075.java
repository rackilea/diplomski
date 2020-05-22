Cursor Cur = DB.RetriveLoggedUsersData(DB, Username);
if (Cur.moveToFirst()) {
    DBFName = Cur.getString(0);
    DBLName = Cur.getString(1);
    DBEmail = Cur.getString(2);
}
Cur.close();