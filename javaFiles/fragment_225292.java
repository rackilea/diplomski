public class SQLiteDatabaseWrapper {

    private SQLiteDatabase mDatabase;

    public void initDatabase() {
      //obtain the database here and assign it to mDatabase 
    }

    // replicate the SQLiteDatabase methods 
    public void execSQL(String sql) {
       //insert whatever logic you have for measurement
       // do the measurement
       mDatabase.execSQL(sql); 
    }
    // other methods from SQLiteDatabase 
}