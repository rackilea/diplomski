//---retrieves all the records---
public Cursor getAllRecords()
{SQLiteDatabase db = DBHelper.getWritableDatabase();
String query ="SELECT * FROM" + DATABASE_TABLE;
Cursor data = db.rawQuery(query,null);
    return data;
}

//---retrieves a particular record---
public Cursor getRecord()
{String query1 ="SELECT * FROM" + KEY_TITLE;
    Cursor mCursor = db.rawQuery(query1,null);
    if (mCursor != null) {
        mCursor.moveToFirst();
    }
    return mCursor;
}