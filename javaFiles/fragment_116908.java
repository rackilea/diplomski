String sql = "SELECT * FROM table_bla LIMIT 1";
SQLiteDatabase database = dbHelper.getWritableDatabase();
Cursor cursor = database.rawQuery(sql, null);

cursor.moveToFirst();
String x = cursor.getString(cursor.getColumnIndex("x"));
cursor.close();
database.close();