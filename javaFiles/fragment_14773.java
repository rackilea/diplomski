public ArrayList<UserInfo> get_user_by_id(String id) {
    ArrayList<UserInfo> listUserInfo = new ArrayList<UserInfo>();
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_APP_ID}, COLUMN_APP_ID + "=?", new String[]{id + ""}, null, null, null);

    if (cursor != null) {

        while (cursor.moveToNext()) {
          UserInfo userInfo = new UserInfo();
          userInfo.setAppId(cursor.getString(cursor.getColumnIndex(COLUMN_APP_ID)));
          // HERE YOU CAN MULTIPLE RECORD AND ADD TO LIST 
          listUserInfo.add(userInfo);
        }
    }
 return listUserInfo;
}