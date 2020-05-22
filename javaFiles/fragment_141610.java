public static Cursor getAllData()
{
       Cursor cursor=null;
    if(db!=null)
    {
      cursor=db.query(TABLE_NAME, new String[] 
              { TABLE_COLUMN_ID, TABLE_COLUMN_ONE, 
              TABLE_COLUMN_TWO }, null,
               null, null, null, null);
    }

return cursor;
}