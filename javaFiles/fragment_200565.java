@Override
public void onCreate(SQLiteDatabase db){
    String query = "CREATE TABLE "+ TABLE_PRODUCTS + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_PERSONNAME + " TEXT, "+
            COLUMN_PERSONBLOOD + " TEXT, "+
            COLUMN_PERSONCONTACT + " TEXT, "+
            COLUMN_PERSONNUMBER + " TEXT, " +
            COLUMN_PERSONRELATION + " TEXT " +
            ");";
    //Execute the query
    db.execSQL(query);
}