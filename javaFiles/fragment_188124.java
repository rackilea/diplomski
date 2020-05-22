public boolean Exists(String _id) {
   Cursor cursor = mDb.rawQuery("select 1 from yourTable where _id=%s", 
        new String[] { _id });
   boolean exists = (cursor.getCount() > 0);
   cursor.close();
   return exists;
}