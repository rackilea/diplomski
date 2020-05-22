public void onCreate(SQLiteDatabase db){
    String CREATE_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + nomber +
            " INTEGER PRIMARY KEY," + namapen + " TEXT," + idPen + " INTEGER," 
  + namaGej + " TEXT," + idGej + " TEXT )";
    db.execSQL(CREATE_TABLE);
  }