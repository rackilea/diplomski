@Override
public void onCreate(SQLiteDatabase db) {
    // creating tables
    db.execSQL(DATABASE_CREATE);
    db.execSQL(CREATE_TABLE_SETTINGS);

    // insert default values
    this.addSetting(db, "access_admin_fingers", "2");
}