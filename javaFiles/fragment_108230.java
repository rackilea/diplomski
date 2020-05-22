ContentValues insertValues = new ContentValues();
insertValues.put(KEY_CLASS, qclass);
insertValues.put(KEY_QUESTION, question);   
yourDbName.insertWithOnConflict(DATABASE_TABLE, null, insertValues, SQLiteDatabase.CONFLICT_IGNORE);  

KEY_QUESTION + " TEXT NOT NULL UNIQUE);";