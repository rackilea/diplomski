public class DBHelper extends SQLiteOpenHelper{

private final static String DB_PATH = "/data/data/[YOUR PACKAGE HERE]/databases/";

String dbName;
Context context;

File dbFile;

public DBHelper(Context context, String dbName, CursorFactory factory,
        int version) {
    super(context, dbName, factory, version);
    this.context = context;
    this.dbName = dbName;
    dbFile= new File(DB_PATH + dbName);
}

@Override
public synchronized SQLiteDatabase getWritableDatabase() {

    if(!dbFile.exists()){
        SQLiteDatabase db = super.getWritableDatabase();
        copyDataBase(db.getPath());
    }
    return super.getWritableDatabase();
}

@Override
public synchronized SQLiteDatabase getReadableDatabase() {
    if(!dbFile.exists()){
        SQLiteDatabase db = super.getReadableDatabase();
        copyDataBase(db.getPath());
    }
    return super.getReadableDatabase();
}

@Override
public void onCreate(SQLiteDatabase db) {}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

private void copyDataBase(String dbPath){
    try{
        InputStream assestDB = context.getAssets().open("databases/"+dbName);

        OutputStream appDB = new FileOutputStream(dbPath,false);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = assestDB.read(buffer)) > 0) {
            appDB.write(buffer, 0, length);
        }

        appDB.flush();
        appDB.close();
        assestDB.close();
    }catch(IOException e){
        e.printStackTrace();
    }

}

}