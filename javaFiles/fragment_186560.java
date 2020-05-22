String sql = "SELECT Title FROM Sports;";
Cursor cursor = db.rawQuery(sql, null);
if (cursor == null)
   return;
String[] titleArray = new String[cursor.getCount()];
 while (cursor.moveToNext()) {
     title = cursor.getString(0);
     titleArray[i] = title;
     i++;  
}