public boolean isEmpty(){
   SQLiteDatabase db;
   db=new UserDatabase(context).getWritableDatabase();
   Cursor cursor=db.rawQuery("SELECT * FROM "+UserDatabase.TABLE_NAME,null);

   if (cursor.moveToFirst()){
        return false; //because its not empty it has something thats why the cursor moved!
   }else {
        return true; //because it does not have anything and the cursor has nothing so return its really empty!
   }
 }