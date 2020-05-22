String  query = ("SELECT " + COL_0 + " FROM " + TABLE_NAME + " WHERE " + COL_5 + " = ?"); // That's right, quotes aren't needed for a parameterized query.
String result = "";
Cursor cursor = db.rawQuery(query,new String[] {note} );
if (cursor.moveToFirst()) {
    result = cursor.getString(cursor.getColumnIndex(COL_0));
}
cursor.close();
return result;