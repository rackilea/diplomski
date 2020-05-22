public Cursor getAllRows() 
    {
        return myDataBase.query(DATABASE_TABLE, new String[] {
                KEY_ROWID, 
                KEY_NAME,
                KEY_YEAR,
                     KEY_QUOTE,
                     KEY_REF}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }