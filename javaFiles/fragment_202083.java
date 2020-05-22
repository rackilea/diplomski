public String dbToStringDairy()
    {

        SQLiteDatabase db = getWritableDatabase();
        String dbStringDairy = "";
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
    while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(COLUMN_ID))!=null)
            {
                dbStringDairy += " ";
                dbStringDairy += c.getString(c.getColumnIndex(COLUMN_PRODUCT_DAIRY));
                dbStringDairy += "\n";

            }
          c.moveToNext();
        }
        db.close();

        //Replace the `null` into other useful information
        if(dbStringDairy==null){
          dbStringDairy="No Results"; 
        }


        return dbStringDairy;
    }