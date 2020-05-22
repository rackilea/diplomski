Cursor mCursor = database.getReadableDatabase.rawQuery("SELECT * FROM User where UserName='Rakesh' and Password='123' and Active='true'",null);

  if(mCursor.getCount()>0 &&  mCursor.moveToFirst()){

  do{
   Log.d("data: ",mCursor.getString(0));

   }while(mCursor.moveToNext(););

  }