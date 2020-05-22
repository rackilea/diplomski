public class DBConnect extends SQLiteOpenHelper 
{
    public String DB_PATH;
    public String DB_NAME;
    public final String DB_PART1_NAME="Database.sqlite";

    public SQLiteDatabase db;
    private final Context myContext;
    private final String TAG="DBConnect";
    private final static int DATABASE_VERSION = 1;

    /**
     * Constructor Takes and keeps a reference of the passed context in order to
     * access to the application assets and resources.
     * 
     * @param context
     * @param db_name
     */
    public DBConnect(Context context,String db_name) 
    {
        super(context, db_name, null, DATABASE_VERSION);
        this.myContext = context; 
        DB_PATH = Global.DB_PATH;
        DB_NAME = db_name;
        try{
            createDataBase();
            openDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a empty database on the system and rewrites it with your own
     * database.
     * */
    public void createDataBase() throws Exception 
     {
        boolean dbExist = checkDataBase();
        if (dbExist){
            System.out.println("Database Exist");
        }
        else
        {
            this.getReadableDatabase();
            try{
                copyDataBase();
            }catch (Exception e){
                throw new Error(e.getMessage());
            }
        }
     }

    /**
     * Check if the database already exist to avoid re-copying the file each
     * time you open the application.
     * 
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() 
     {
        SQLiteDatabase checkDB = null;
        try 
        {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        }catch (Exception e){
            System.out.println("database does't exist yet.");
        }

        if (checkDB != null){
            checkDB.close();
            System.out.println("My db is:- " + checkDB.isOpen());
            return true;
        }
        else 
            return false;
     }

    public void copyCacheToMain(DBConnect objCache)throws IOException 
    {
        // Open your local db as the input stream
        String inFileName = objCache.DB_PATH + objCache.DB_NAME;
        InputStream myInput = new FileInputStream(inFileName);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) 
         {
            myOutput.write(buffer, 0, length);
         }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
        Log.d("CTM","Cache To Main Database Copied !");
     }
    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     * */

    private  void copyDataBase() throws Exception 
    {
        try {
            if(DB_NAME.equalsIgnoreCase(Global.DB_MAIN))
            {
                InputStream myInput = myContext.getAssets().open(DB_PART1_NAME);
                String outFileName = DB_PATH + DB_NAME;
                OutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;

                while ((length = myInput.read(buffer)) > 0){
                    myOutput.write(buffer, 0, length);
                }
                myInput.close();
                myOutput.flush();
                myOutput.close();
            }
            else {
                InputStream myInput = myContext.getAssets().open(DB_NAME);
                String outFileName = DB_PATH + DB_NAME;
                OutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;

                while ((length = myInput.read(buffer)) > 0){
                    myOutput.write(buffer, 0, length);
                }
                myInput.close();
                myOutput.flush();
                myOutput.close();
            }
            System.out.println(DB_NAME+"Database Copied !");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void openDataBase() throws SQLException 
    {
        // Open the database
        String myPath = DB_PATH + DB_NAME;
        db = SQLiteDatabase.openDatabase(myPath, null,SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() 
    {
        if (db != null)
            db.close();
        System.out.println("My db is:- " + db.isOpen());
        super.close();
    }

    public synchronized void execNonQuery(String sql) {
        try {
            db.execSQL(sql);
            Log.d("SQL",sql );          
        } catch (Exception e) {
            Log.e("Err",e.getMessage());            
        } finally {
            //closeDb();    
        }
    }
    public synchronized Cursor execQuery(String sql) {
        Cursor cursor=null;
        try {
            cursor = db.rawQuery(sql, null);
            Log.d("SQL",sql );          
        } catch (Exception e) {
            Log.e("Err",e.getMessage());            
        } finally {
            //closeDb();    
        }
        return cursor;
    }
    public synchronized Cursor execQuery(String sql, String[] selectionArgs) {
        Cursor cursor=null;
        try {
            cursor = db.rawQuery(sql, selectionArgs);
            Log.d("SQL",sql );          
        } catch (Exception e) {
            Log.e("Err",e.getMessage());            
        } finally {
            //closeDb();    
        }
        return cursor;
    }
    public long insert(String tblName, Object myObj)
    {
        ContentValues initialValues = new ContentValues();
        long result = -1;

        Field[] fields =  myObj.getClass().getFields();

            try{
                for (Field field : fields){
                    initialValues.put(field.getName(), (String) field.get(myObj));
//                  Log.i(TAG, field.getName()+" = "+initialValues.getAsString(field.getName()));
                }
                result = db.insertOrThrow(tblName, null, initialValues);
            } catch (IllegalArgumentException e) {              
                e.printStackTrace();
            } catch (IllegalAccessException e) {                
                e.printStackTrace();
            }catch (SQLException e) {
                e.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }
        return result;
    }

    /**
     * 
     * @param sqlQuery SQL query to be fired
     * @param myObj Object to be fetched
     * @return Returns a Vector object containing raws fetched by the sqlQuery
     */

    public ArrayList<Object> fetchAllRows(String sqlQuery, Object myObj)
    {
        ArrayList<Object> records = new ArrayList<Object>();
        Object newObj;
        Cursor cursor = execQuery(sqlQuery);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                //          System.out.println("Test While");
                newObj = ClassUtils.newObject(myObj);
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    String key = cursor.getColumnName(i);
                    String value = cursor.getString(i);
                    if (value == null) {
                        value = "";
                    }
                    ClassUtils.objectMapping(newObj, key, value);
                }
                records.add(newObj);
            }
            cursor.close();
        }
        return records;
    }

    @Override
    public void onCreate(SQLiteDatabase db) 
    {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
    {

    }
}