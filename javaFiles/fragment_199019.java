public class DBHelper extends SQLiteOpenHelper {

public static final String DATABASE_NAME = "FreedomKitchenDB.db";
private static final int DATABASE_VERSION =1;
//********** LOGIN TABLE COLUMNS *************

public static final String LOGIN_TABLE_NAME = "login_details";
public static final String LOGIN_COLUMN_ID = "user_id";
public static final String LOGIN_COLUMN_USERNAME = "username";
public static final String LOGIN_COLUMN_PASSWORD = "password";

//********** REGISTRATION TABLE COLUMNS *************

public static final String REG_TABLE_NAME = "user_details";
public static final String REG_COLUMN_ID = "user_id";
public static final String REG_COLUMN_FIRST_NAME = "first_name";
public static final String REG_COLUMN_LAST_NAME = "last_name";
public static final String REG_COLUMN_GENDER = "gender";
public static final String REG_COLUMN_AGE = "age";
public static final String REG_COLUMN_COUNTRY = "country";


public DBHelper(Context context)
{
    super(context, DATABASE_NAME, null,DATABASE_VERSION);
}

@Override
public void onCreate(SQLiteDatabase db) {
    // TODO Auto-generated method stub
    String CREATE_REG_TABLE="CREATE TABLE " +REG_TABLE_NAME+"("+REG_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+REG_COLUMN_FIRST_NAME+" TEXT,"+REG_COLUMN_LAST_NAME+" TEXT,"+REG_COLUMN_GENDER+" TEXT,"+REG_COLUMN_AGE+" TEXT,"+REG_COLUMN_COUNTRY+" TEXT)";
    db.execSQL(CREATE_REG_TABLE);
    String CREATE_LOGIN_TABLE="CREATE TABLE " + LOGIN_TABLE_NAME + "(" + LOGIN_COLUMN_ID + " INTEGER," + LOGIN_COLUMN_USERNAME + " TEXT," + LOGIN_COLUMN_PASSWORD + " TEXT,FOREIGN KEY(" + LOGIN_COLUMN_ID + ") REFERENCES " + REG_TABLE_NAME + "(" + REG_COLUMN_ID + "))";
    db.execSQL(CREATE_LOGIN_TABLE);
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // TODO Auto-generated method stub
    db.execSQL("DROP TABLE IF EXISTS contacts");
    onCreate(db);
}



public boolean insertUserDetail (String first_name,String last_name,String age,String gender,String country,String username,String password)
{
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(REG_COLUMN_FIRST_NAME, first_name);
    contentValues.put(REG_COLUMN_LAST_NAME, last_name);
    contentValues.put(REG_COLUMN_GENDER, gender);
    contentValues.put(REG_COLUMN_AGE, age);
    contentValues.put(REG_COLUMN_COUNTRY, country);
    ContentValues mContentValues1=new ContentValues();
    mContentValues1.put(LOGIN_COLUMN_USERNAME,username);
    mContentValues1.put(LOGIN_COLUMN_PASSWORD,password);
    db.insert(LOGIN_TABLE_NAME, null, mContentValues1);
    db.insert(REG_TABLE_NAME, null, contentValues);
    return true;
}

public boolean Login(String username, String password) throws SQLException
{
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor mCursor = db.rawQuery("SELECT * FROM " + LOGIN_TABLE_NAME + " WHERE "+LOGIN_COLUMN_USERNAME+"=? AND "+LOGIN_COLUMN_PASSWORD+"=?", new String[]{username,password});
    if (mCursor != null) {
        if(mCursor.getCount() > 0)
        {
            return true;
        }
    }
    return false;
}}