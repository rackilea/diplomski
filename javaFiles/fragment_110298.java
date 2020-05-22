public class DatabaseHelper extends SQLiteOpenHelper {
     private static final int DB_VERSION = 1;
     private static final String DB_NAME = "myDB.db";

     public DatabaseHelper(Context ctx) {
         super(ctx, DB_NAME, null, DB_VERSION);
     }

     @Override
     public void onCreate(SQLiteDatabase db) {
         String query = "CREATE TABLE myTable(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, age INTEGER NOT NULL)";
         db.execSQL(query);
         db.close();
     }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         ...
     }
}