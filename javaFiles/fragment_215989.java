Cursor cursor = getContentResolver().
    query( Contacts.CONTENT_URI, 
      new String[]{Contacts.DISPLAY_NAME}, null, null,null);

    if(cursor!=null){
      while(cursor.moveToNext()){

         String name = cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME))
       }