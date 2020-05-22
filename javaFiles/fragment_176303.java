if (c.moveToFirst()){ 
    do{ 
       //if you not need the loop you can remove that
       id = c.getInt(c.getColumnIndex("_id"));
   }
 while(cursor.moveToNext());
}c.close();