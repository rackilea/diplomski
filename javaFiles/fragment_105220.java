public Cursor getItems() {
   String [] columns = new String[] {KEY_ROWSHOPID, KEY_ITEMSHOP, KEY_ITEMNUM, 
                                     KEY_ITEMPRICE};
   Cursor c = ourDatabase.query(DATABASE_TABLESHOP, columns, null, null, null,
                                null, null);
   if (c.moveToFirst()) {
      return c;
   }
   return null;
}


public void onDestroy() {
   super.onDestroy();
   closeSources();
}

private void closeSources() {
   if (c != null) {
      c.close();
   }
   if (db != null) {
      db.close();
   }
}