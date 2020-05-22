public void insertFriendList(String clas,String sub,String name) {

    SQLiteDatabase slb = this.getWritableDatabase();
    ContentValues values = new ContentValues();
            values.put(AttendAppDbOpenHelper.COLUMN_NAME,name);

            values.put(AttendAppDbOpenHelper.COLUMN_SUBJECT,sub);
            values.put(AttendAppDbOpenHelper.COLUMN_CLASS, clas );
    slb.insert(AttendAppDbOpenHelper.TABLE_DETAILS, null, values);
    slb.close();
}