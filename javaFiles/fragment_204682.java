public Cursor getCourseNames() throws SQLException {
    String[] values = {COURSE_NAME};
    mDb = mDbHelper.getReadableDatabase();

    return mDb.query("Course",values,COURSE_ROWID, null, null, null, null, null); 
}