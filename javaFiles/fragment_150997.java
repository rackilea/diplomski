void insertMessage(string user, string message) {
    SQLiteDatabase db = getWritableDatabase();
    try {
        db.beginTransaction();
        try {
            long id = DatabaseUtils.longForQuery(db,
                        "SELECT _id FROM Users WHERE Name = ?",
                        new String[]{ user });
            if (id == -1) {
                ContentValues cv = new ContentValues();
                cv.put("Name", user);
                id = db.insert("Users", null, cv);
            }

            ContentValues cv = new ContentValues();
            cv.put("UserID", id);
            cv.put("Text", message);
            db.insert("Messages", null, cv);

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    } finally {
        db.close();
    }
}