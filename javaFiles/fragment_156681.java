public static final String DATABASE_NAME = "abc.db";
 public final static String DATABASE_PATH = "/data/data/"+ PACKAGE_NAME + 
 "/databases/";
 public static final int DATABASE_VERSION = 1;


  public void createDatabase()  {
    boolean dbExist1 = checkDataBase();
    if (!dbExist1) {
        this.getReadableDatabase();
        try {
            this.close();
            copyDataBase();
        } catch (IOException e) {
            throw new Error("Error copying database");
        }
    }
}

// Check database already exist or not
private boolean checkDataBase() {
    boolean checkDB = false;
    try {
        String myPath = DATABASE_PATH + DATABASE_NAME;
        File dbfile = new File(myPath);
        checkDB = dbfile.exists();
    } catch (SQLiteException e) {
    }
    return checkDB;
}

// Copies your database from your local assets-folder to the just created
// empty database in the system folder
public void copyDataBase() throws IOException {
    String outFileName = DATABASE_PATH + DATABASE_NAME;
    OutputStream myOutput = new FileOutputStream(outFileName);
    InputStream myInput = mContext.getAssets().open(DATABASE_NAME);

    byte[] buffer = new byte[1024];
    int length;
    while ((length = myInput.read(buffer)) > 0) {
        myOutput.write(buffer, 0, length);
    }
    myInput.close();
    myOutput.flush();
    myOutput.close();
}