if (cursor.moveToFirst()) {
        do {
             int id_row=cursor.getInt(cursor.getColumnIndex("id"));
             //int id_row=cursor.getInt(0);
             Log.d("TAG","id is ::"+id_row);
        } while (cursor.moveToNext());
    }