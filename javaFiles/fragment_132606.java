Cursor cursor = db.query(TABLE_USER,
            null, //<<<<<<<<<< null equates to * and thus ALL columns
            selection,
            selectionArgs,
            null,
            null,
            null);