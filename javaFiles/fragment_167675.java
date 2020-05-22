public void onCreate(SQLiteDatabase db) {
   String CREATE_DAY_TABLE = "CREATE TABLE " + TABLE_DAYS + "(" 
 + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DATE + " TEXT," + KEY_HOURS + " INTEGER, " 
 + KEY_UB + " INTEGER," + KEY_BRUTTO + " INTEGER" + ");"; 
 db.execSQL(CREATE_DAY_TABLE);
 }