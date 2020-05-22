public void addSetting(SQLiteDatabase db, String key, String value) {
    ContentValues values = new ContentValues();
    values.put(SETTING_KEY, key);
    values.put(SETTING_VALUE, value);
    db.insert(TABLE_APP_SETTINGS, null, values);
}