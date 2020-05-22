public Cursor fetchAllCountries() {
    Cursor mCursor = this.sqliteDBInstance3.query(DB_TABLE_NAME3,
            new String[] {KEY_ROWID, DB_COLUMN_1_NAME3, DB_COLUMN_2_NAME3,
                DB_COLUMN_3_NAME3 }, null, null, null, null,
        null);

    if (mCursor != null) {
        updateSum(mCursor);
    }
    return mCursor;
}

private void updateSum(Cursor cursor) {
    int sum = 0;
    final int index = cursor.getColumnIndex(COLUMN_NAME);
    for (cursor.moveToFirst; !cursor.isAfterLast(); cursor.moveToNext()) {
        int value = cursor.getInt(index);
        sum += value;
    }
    // do something with sum
}