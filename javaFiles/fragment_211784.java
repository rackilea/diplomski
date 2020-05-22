private  class DatabaseOpenHelper extends SQLiteOpenHelper {

    private final DatabaseOpenHelper hDatabaseOpenHelper =  new DatabaseOpenHelper(mHelperContext); //this line is your problem

....
}