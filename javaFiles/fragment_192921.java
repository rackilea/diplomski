public Cursor queryAll(int nameId) {
    String[] cols = { DBHelperCourse.KEY_COURSE_NAME, DBHelperCourse.KEY_COURSE_CODE,  DBHelperCourse.KEY_START_TIME };
    opnToWrite();
    Cursor c = database_ob.query(DBHelperCourse.TABLE_NAME, cols,
    DBHelperCourse.KEY_ID + "=" + nameId, null, null, null, null);

    return c;
}