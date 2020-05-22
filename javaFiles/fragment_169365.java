// Getting all data
public Cursor getData() {

    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = db.query(TABLE_DATA, new String[] { "UserName",
            "Email", "Password", "BirthDate", "PinCode", "Country",
            "PaypalID", "mNUMBER", "FBID" }, null, null, null, null, null,
            null);

    return cursor;
}