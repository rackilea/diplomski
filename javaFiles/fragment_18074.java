String selectQuery= "SELECT * FROM " + TABLE_XYZ+" ORDER BY column DESC LIMIT 1";
SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);
String str = "";
if(cursor.moveToFirst())
    str  =  cursor.getString( cursor.getColumnIndex(KEY_TEXT) );
cursor.close();
return str;