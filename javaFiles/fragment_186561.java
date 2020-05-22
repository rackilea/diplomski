String sql = "SELECT Title FROM Sports;";
Cursor cursor = db.rawQuery(sql, null);
if (cursor == null)
      return;
ArrayList<String> titleArrayList = new ArrayList<String>();
while (cursor.moveToNext()) {
     title = cursor.getString(0);
     titleArrayList.add(title);       
}