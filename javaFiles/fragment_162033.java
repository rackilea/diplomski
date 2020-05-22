public class DatabaseHelper extends SQLiteOpenHelper{

     //final static stuff because you'll want to access it(the data) in other classes.
     public static final String DB_NAME = "scores.db";
     public static final String SCORE_TABLE = "scores";
     public static final int VERSION = 3;
     private Context context;

     public DatabaseHelper(Context context){
         super(context, DB_NAME, null, VERSION);
         this.context = context;
     }

     public SQLiteDatabase getDatabase(){
         return getWritableDatabase();
     }

     @Override
     public void onCreate(SQLiteDatabase db) {
         //our code for creating the ScoreTable..
         db.execSQL("CREATE TABLE "
                 + SCORE_TABLE +
                 "(" +
                 "ID INT NOT NULL, " +
                 "Score INT);");
         //now we create one row of data.
         db.execSQL("INSERT INTO " + DatabaseHelper.SCORE_TABLE + " (ID, Score) VALUES (1, 0);");
     }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

         //if the version is greater than the previous one, we re-create it.
         if(newVersion > oldVersion) {
             db.execSQL("DROP TABLE IF EXISTS " + SCORE_TABLE);
             onCreate(db);
         }
     }
 }
public class DataSource{
    //this is a link between your app and the database. you don't have to use this.
    private SQLiteDatabase database;
    private Context context;
    private DatabaseHelper helper;
    public DataSource(Context context){
        //initiate our objects.
        this.helper = new DatabaseHelper(context);
        this.database = helper.getWritableDatabase();
        this.context = context;
    }

    public void setScore(int score){
        //we update the Score column where the ID is 1
            database.execSQL("UPDATE " + DatabaseHelper.SCORE_TABLE + " SET Score = " + score + " WHERE ID = 1;");
    }
    public int getScore(){
        //we get all of the columns that have a ID of one. There should only be one column.
        Cursor score = database.rawQuery("SELECT * FROM " + DatabaseHelper.SCORE_TABLE + " WHERE ID = 1", null);
        //this isn't especially needed, but i found that adding checks and balances keeps crashes down.
        if(score.getColumnCount() < 1){
            return 0;
        } else {
            //this is important! You have to move the cursor to the first row.
            score.moveToFirst();
            //now we get the data on row 1 (actually 2 if you look at it from a 1 based number system..)
            int mscore = score.getInt(1);
            //close the cursor
            score.close();
            //and finally return the score.
            return mscore;
        }
    }

}