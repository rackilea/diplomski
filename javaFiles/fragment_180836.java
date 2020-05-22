public User getSingleUserInfo(String email){

    SQLiteDatabase database = this.getWritableDatabase();
    Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USER_EMAIL + "=" + email);
    cursor.moveToFirst();

    //setting related user info in User Object
    User user = new User();
    user.setUserId(cursor.getInt(cursor.getColumnIndexCOLUMN_USER_ID ));
    user.setFirstName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FIRST_NAME));
    user.setLastName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_LAST_NAME ));
    user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL ));
    user.setPhoneNumber(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PHONE_NUMBER ));
    user.setBirthday(cursor.getString(cursor.getColumnIndex(COLUMN_USER_BARTH_DAY ));
    user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD));
    user.setGender(cursor.getString(cursor.getColumnIndex(COLUMN_USER_GENDER ));

    //close cursor & database
    cursor.close();
    database.close();

    return user;

}