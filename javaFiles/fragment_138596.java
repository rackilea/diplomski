public void onCreate(SQLiteDatabase db){

    String sqlstatement = "CREATE TABLE " + TABLE_USER + "( " +
            COL_ID + " integer primary key autoincrement, " +
            COL_EMAIL + " text, " +
            COL_PASSWORD + " text, " +
            COL_NAME + " text, " +
            COL_SURNAME +  " text, " +
            COL_ADDRESS + " text, " +
            COL_SPORT + " text, " +
            COL_MOBILE + " text, " +
            COL_POSITION + " text ) ";

       db.execSQL(sqlstatement);

}