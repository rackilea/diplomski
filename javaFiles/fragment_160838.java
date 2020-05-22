if(cursor.moveToFirst()) {
   do {
       String name = cursor.getString(cursor.getColumnIndex("name"));
   }while (cursor.moveToNext());
}
cursor.close();