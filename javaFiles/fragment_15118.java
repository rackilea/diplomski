package com.app.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {

    public static final String KEY_ROWID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String TAG = "DBAdapter";

    //public static final String DATABASE_NAME = "my_db";
    //public static final String DATABASE_TABLE = "contacts";
    //public static final int DATABASE_VERSION = 1;

    public static final String START_TBL_CREATION = "create table "+Appiah.DATABASE_TABLE+" (_id integer primary key autoincrement, ";

    public static final String [] TABLE_COLUMNS_TO_BE_CREATED = new String []{
        KEY_NAME+" text not null, ",
        KEY_EMAIL+" text not null"
    };

    public static final String END_TBL_CREATION = ");";

    private static final String DATABASE_CREATE = START_TBL_CREATION
            + TABLE_COLUMNS_TO_BE_CREATED[0]
            + TABLE_COLUMNS_TO_BE_CREATED[1]
    + END_TBL_CREATION;

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter (Context ctx){
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);//there would be an error initially but just keep going...
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{//after importing for "SQLiteOpenHelper", Add unimplemented methods

        DatabaseHelper(Context context){
            super (context, Appiah.DATABASE_NAME, null, Appiah.DATABASE_VERSION);//pls. note : "Appiah" is the class in which all the common methods, variables, etc. are sitting.
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try{
                db.execSQL(DATABASE_CREATE);
            }catch(SQLException e){
                e.printStackTrace();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version "+ oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }

    //opens the database
    public DBAdapter open() throws SQLiteException{
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //closes the database
    public void close(){
        DBHelper.close();
    }

    //insert a contact into the database
    public long insertContact(String name, String email){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_EMAIL, email);
        return db.insert(Appiah.DATABASE_TABLE, null, initialValues);
    }

    //deletes a particular contact
    public boolean deleteContact(long rowId){
        String whereClause = KEY_ROWID + "=" + rowId;
        String[] whereArgs = null;
        return db.delete(Appiah.DATABASE_TABLE, whereClause, whereArgs) > 0;
    }

    //retrieves all the contacts
    public Cursor getAllContacts(){
        String[] columns = new String[]{KEY_ROWID, KEY_NAME, KEY_EMAIL};
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;
        return db.query(Appiah.DATABASE_TABLE, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    //retrieve a particular contact with ID as input
    public Cursor getContact_with_ID(long rowId) throws SQLException {
        boolean distinct = true;
        String table = Appiah.DATABASE_TABLE;
        String [] columns = new String []{KEY_ROWID, KEY_NAME, KEY_EMAIL};
        String selection = KEY_ROWID + "=" + rowId;
        String [] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;
        String limit = null;
        Cursor mCursor = db.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);

        if(mCursor != null){
            mCursor.moveToFirst();
        }

        return mCursor;

    }

    public Cursor getContact_with_nameEntered(String name_str) throws SQLException {
        boolean distinct = true;
        String table = Appiah.DATABASE_TABLE;
        String [] columns = new String []{KEY_ROWID, KEY_NAME, KEY_EMAIL};
        String selection = KEY_NAME + "=" + name_str;//check again and do "%" thing to expand scope and increase chances of a name getting found or populated
        String [] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;
        String limit = null;
        Cursor mCursor = db.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);

        if(mCursor != null){
            mCursor.moveToFirst();
        }

        return mCursor;

    }

    //update a contact
    public boolean updateContact(long rowId, String name, String email){
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_EMAIL, email);

        String table = Appiah.DATABASE_TABLE;
        ContentValues values = args;
        String whereClause = KEY_ROWID + "=" + rowId;
        String []whereArgs = null;

        return db.update(table, values, whereClause, whereArgs) > 0;
    }

    /*

     TO USE ANY OF THE ABOVE METHODS :
     1. type this before in your "onCreate()" : DBAdapter db = new DBAdapter(this);
     2. in the special case of getting all contacts to display : do the ff : 

        db.open();
        Cursor c = db.getAllContacts();
        if(c.moveToFirst()){
            do{
                textView.setText("ID : " + c.getString(0) + "\nName : " + c.getString(1) + "\nEmail Address : " + c.getString(2) );
            }while(c.moveToNext());//the "while" added ensures that, the looping process occurs
        }
        db.close();

     */

}