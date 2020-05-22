Cursor cursor = db.query(TABLE_USER,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null);
    int cursorCount = cursor.getCount();