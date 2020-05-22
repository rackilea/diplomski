public Cursor fetchReminder(long rowId) throws SQLException {
        mCursor = mDb.query(true, DATABASE_TABLE, new String[] { KEY_ROWID,
                KEY_TITLE, KEY_BODY, KEY_DATE_TIME }, KEY_ROWID + "="
                + rowId, null, null, null, null, null);
    if (mCursor != null  && mCursor.getCount()>0) 
    { mCursor.moveToFirst(); }

    return mCursor;

}