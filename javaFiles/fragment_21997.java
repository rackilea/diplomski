public class DataSourceTools {

   private SQLiteOpenHelper handler;
   private SQLiteDatabase db;

   public DataSourceTools(SQLiteOpenHelper handler) {
      this.handler = handler;
   }

   public void saveObject(String table, ContentValues data) {
      try {
         db = openWrite(this.handler);
         if (db != null) {
            db.insert(table, nullColumnHackName, data);
         }
      }
      finally {
         close(db);
      }
   }

   public void updateObject(String table, ContentValues dataToUpdate) {
      try {
         db = openWrite(this.handler);
         if (db != null) {
            String whereClause = "...";
            String[] whereArgs = {...};
            db.update(table, dataToUpdate, whereClause, whereArgs);
         }
      }
      finally {
         close(db);
      }
   }

   public void deleteObject(String table, ContentValues data) {
      try {
         db = openWrite(this.handler);
         if (db != null) {
            String whereClause = "...";
            String[] whereArgs = {...};
            db.delete(table, whereClause, whereArgs);
         }
      }
      finally {
         close(db);
      }
   }

   public Object findObject(String table, ContentValues data) {
      Object myObject = null; 
      Cursor c = null;
      try {
         String[] columns = {"id", "name", "lastname", ...};
         String selection = "id = ?";
         String[] selectionArgs = {data.getAsString("key_id")};
         c = db.query(table, columns, selection, selectionArgs, null, null, null);
         if (c.moveToFirst()) {
            myObject = new Object();
            myObject.setId(c.getInt(c.getColumnIndex("id")));
            myObject.setName(c.getString(c.getColumnIndex("name")));
            myObject.setLastName(c.getString(c.getColumnIndex("lastname")));
         }
         return myObject;
      }
      finally {
         if (c != null) {
            c.close()
         }
         close(db);
      }
   }

   public List<Object> findAll(String table) {
      List<Object> objects = new ArrayList<Object>(); 
      Object myObject = null; 
      Cursor c = null;
      try {
         String[] columns = {"id", "name", "lastname", ...};
         c = db.query(table, columns, null, null, null, null, null);
         if (c.moveToFirst()) {
            myObject = new Object();
            myObject.setId(c.getInt(c.getColumnIndex("id")));
            myObject.setName(c.getString(c.getColumnIndex("name")));
            myObject.setLastName(c.getString(c.getColumnIndex("lastname")));
            objects.add(myObject);
         }
         return objects;
      }
      finally {
         if (c != null) {
            c.close()
         }
         close(db);
      }
   }

   private final synchronized SQLiteDatabase openWrite(SQLiteOpenHelper handler) {
      if (handler != null) {
         return handler.getWritableDatabase();
      }
      return null;
   }

   private final synchronized SQLiteDatabase openRead(SQLiteOpenHelper handler) {
      if (handler != null) {
         return handler.getReadableDatabase();
      }
      return null;
   }

   private final synchronized void close(SQLiteDatabase db) {
      if (db != null && db.isOpen()) {
         db.close();
      }
   }
}