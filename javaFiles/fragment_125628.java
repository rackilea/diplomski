do {
     List.add(
            cursor.getString(1) +","
            cursor.getString(1) +","
            ...
            +cursor.getString(n));
    } while (cursor.moveToNext());