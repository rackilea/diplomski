import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

class SQLiteAdapter {

private static final String DB_NAME = "DATABASE";
private static final String KEY_TABLE = "KEY_TABLE";

private static final int DB_VERSION = 1;

private static final String KEY_ID = "_id";
private static final String KEYWORD = "Keyword";
private static final String COUNT = "COUNT";
private static final String CONTACT_NAMES = "CONTACT_NAMES";
private static final String CONTACT_NUMBERS = "CONTACT_NUMBERS";


//create table MY_DATABASE (ID integer primary key, Content text not null);
private static final String SCRIPT_CREATE_DATABASE =
        "create table " + KEY_TABLE + " ("
                + KEY_ID + " integer primary key autoincrement, "
                + KEYWORD + " text, "
                + CONTACT_NAMES + " text, "
                + CONTACT_NUMBERS + " text, "
                + COUNT + " integer);";

private SQLiteHelper sqLiteHelper;
private SQLiteDatabase sqLiteDatabase;

private Context context;

SQLiteAdapter(Context c) {
    context = c;
}

private void openToRead() throws android.database.SQLException {
    sqLiteHelper = new SQLiteHelper(context, DB_NAME, null, DB_VERSION);
    sqLiteDatabase = sqLiteHelper.getReadableDatabase();

}

private void openToWrite() throws android.database.SQLException {
    sqLiteHelper = new SQLiteHelper(context, DB_NAME, null, DB_VERSION);
    sqLiteDatabase = sqLiteHelper.getWritableDatabase();

}

private void close() {
    sqLiteHelper.close();
}

boolean insert(SQLiteAdapter sqLiteAdapter, String keyword, String contact_names, String contact_numbers, int count) {

    sqLiteAdapter.openToWrite();
    ContentValues contentValues = new ContentValues();

    contentValues.put(KEYWORD, keyword);
    contentValues.put(CONTACT_NAMES, contact_names);
    contentValues.put(CONTACT_NUMBERS, contact_numbers);
    contentValues.put(COUNT, count);
    sqLiteDatabase.insert(KEY_TABLE, null, contentValues);
    sqLiteAdapter.close();
    return true;
}

void deleteRow(SQLiteAdapter sqLiteAdapter, String id) {

    sqLiteAdapter.openToWrite();
    sqLiteDatabase.execSQL("delete from " + KEY_TABLE + " where _id='" + id + "'");
    sqLiteAdapter.close();


}

ArrayList<RecordModel> getAllRecords(SQLiteAdapter sqLiteAdapter) {

    sqLiteAdapter.openToRead();
    ArrayList<RecordModel> listItems = new ArrayList<>();

    String[] columns = new String[]{KEY_ID, KEYWORD, CONTACT_NAMES, CONTACT_NUMBERS, COUNT};
    Cursor cursor = sqLiteDatabase.query(KEY_TABLE, columns,
            null, null, null, null, null);

    if (cursor.moveToFirst()) {
        do {
            RecordModel recordModel = new RecordModel();
            recordModel.setCount(cursor.getInt(cursor.getColumnIndex(COUNT)));
            recordModel.setId(cursor.getString(cursor.getColumnIndex(KEY_ID)));
            recordModel.setKeyword(cursor.getString(cursor.getColumnIndex(KEYWORD)));
            recordModel.setContactNames(cursor.getString(cursor.getColumnIndex(CONTACT_NAMES)));
            recordModel.setContactNumbers(cursor.getString(cursor.getColumnIndex(CONTACT_NUMBERS)));
            listItems.add(recordModel);
        } while (cursor.moveToNext());
    }

    cursor.close();

    sqLiteAdapter.close();

    return listItems;
}


public class SQLiteHelper extends SQLiteOpenHelper {

    SQLiteHelper(Context context, String name,
                 CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(SCRIPT_CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

     }

   }
}