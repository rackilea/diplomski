String query = "pragma table_info(Table1)";
c = db.rawQuery(query, null);
if (c.moveToFirst()) {
   do {
      String name = c.getString(c.getColumnIndex("name"));
      String type = c.getString(c.getColumnIndex("type"));
      Log.i("Information", name + " " + type);
   } while (c.moveToNext());
}