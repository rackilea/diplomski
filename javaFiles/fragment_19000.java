DatabaseHelper extends SQLiteOpenHelper {

  @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(//Create your table first);
      --this will insert the master data when the table will be created for the first time 
   db.execSQL("INSERT INTO " + TABLE + " (" + COL1 + ", " + COL2 + "," + COL3 + "," + COL4 + "," + COL5 + ","+COL6+")" +
            " VALUES(VAL1,VAL2,VAL3,VAL4,VAL5,VAL6);");
    }

  @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
   }
 }