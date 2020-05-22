public int getCount() {
    Cursor c = null;
    try {
        db = Dbhelper.getReadableDatabase();
        String query = "select count(*) from TableName where name = ?";
        c = db.rawQuery(query, new String[] {name});
        if (c.moveToFirst()) {
            return c.getInt(0);
        }
        return 0;
    }
    finally {
        if (c != null) {
            c.close();
        }
        if (db != null) {
            db.close();
        }
    }
}

if (getCount() == 0) {
   //perform inserting
}