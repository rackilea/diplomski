public List<DBEntry> getAllDBEntrys()
    {
        List<DBEntry> DBEntrys = new ArrayList<DBEntry>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_APPTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) 
        {
            do 
            {
                DBEntry DBEntry = new DBEntry();
                DBEntry .setID(Integer.parseInt(cursor.getString(0)));
                DBEntry .setName(cursor.getString(1));
                DBEntry .setPhoneNumber(cursor.getString(2));
                // Adding to list
                DBEntrys .add(DBEntry );
            } while (cursor.moveToNext());
        }

        // return list
        return DBEntrys ;
    }