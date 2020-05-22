public boolean insertTransaction(int count) throws SQLException {
    boolean result = false;
    try {
        db = openWrite(DataSource.getInstance(mContext));
        ContentValues values = new ContentValues();
        if (db != null) {
            db.beginTransaction();
            for (int i = 0; i < count; i++) {
                values.put(SQLConstants.KEY_TYPE, "type" + i);
                values.put(SQLConstants.KEY_DATE, new Date().toString());
                db.insertOrThrow(SQLConstants.TEST_TABLE_NAME, SQLConstants.KEY_TYPE, values);
                values.clear();
            }
            db.setTransactionSuccessful();
            result = true;
        }
        return result;
    }
    finally {
        if (db != null) {
            db.endTransaction();
        }
        close(db);
    }
}