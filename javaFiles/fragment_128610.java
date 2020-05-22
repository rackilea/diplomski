public class DBHelper extends SQLiteOpenHelper {

public SQLiteDatabase database = null;
public File databaseFile;
public static String databaseName = "collegeDb.sqlite";
public String databasePath = "";
Context mContext;

public DBHelper(Context paramContext) {

    super(paramContext, databaseName, null, 1);
    this.mContext = paramContext;

    Log.d("data", "package name:" + paramContext.getPackageName());

    this.databasePath = ("data/data/" + paramContext.getPackageName() + "/databases/"+databaseName);
    this.databaseFile = new File(this.databasePath);
    if (!this.databaseFile.exists())
        try {
            deployDataBase(DBHelper.databaseName, this.databasePath);
            return;
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
}

private void deployDataBase(String dbNAme, String dbPath)
        throws IOException {
    InputStream localInputStream = this.mContext.getAssets().open(dbNAme);
    FileOutputStream localFileOutputStream = new FileOutputStream(dbPath);
    byte[] arrayOfByte = new byte[1024];
    while (true) {
        int i = localInputStream.read(arrayOfByte);
        if (i <= 0) {
            localFileOutputStream.flush();
            localFileOutputStream.close();
            localInputStream.close();
            return;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
    }
}

@Override
public synchronized void close() {

    if (database != null)
        database.close();

    super.close();

}
@Override
public void onCreate(SQLiteDatabase db) {
    // TODO Auto-generated method stub

}

@Override  
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
 // TODO Auto-generated method stub 

} 
/**
 * Getting all colleges
 * returns list of colleges
 * */
public List<String> getAllColleges(){
    List<String> colleges = new ArrayList<String>();

    // Select All Query
    String selectQuery = "SELECT * FROM collegeslist";

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            colleges.add(cursor.getString(1));
        } while (cursor.moveToNext());
    }

    // closing connection
    cursor.close();
    db.close();

    // returning colleges
    return colleges;
}

 /**
  * Getting all products
  * returns list of products
  * */
 public List<String> getAllProducts(){
     List<String> products = new ArrayList<String>();

     // Select All Query
     String selectQuery = "SELECT * FROM productslist";

     SQLiteDatabase db = this.getReadableDatabase();
     Cursor cursor = db.rawQuery(selectQuery, null);

     // looping through all rows and adding to list
     if (cursor.moveToFirst()) {
         do {
             products.add(cursor.getString(1));
         } while (cursor.moveToNext());
     }

     // closing connection
     cursor.close();
     db.close();

     // returning products
     return products;
 }
}