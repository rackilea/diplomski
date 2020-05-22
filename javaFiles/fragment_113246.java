public MyDatabase {

public final MyDatabase INSTANCE = new MyDatabase();

private DbHelper mHelper;

public Cursor someMyQuery() {
    return mHelper.query(...);
}

private MyDatabase() {
    mHelper = new DbHelper(MyApp.context());
    ...
}

private static class DbHelper extends SQLiteOpenHelper {
   onCreate() {...}
   onUpdate() {...}
}

}