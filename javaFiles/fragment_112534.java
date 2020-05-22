Cursor cursor = db.query(TABLE_CONTACTS, //Table to query
            columns,                    //columns to return
            selection,                  //columns for the WHERE clause
            selectionArgs,              //The values for the WHERE clause
            null,                       //group the rows
            null,                       //filter by row groups
            null);                      //The sort order

    int cursorCount = cursor.getCount();