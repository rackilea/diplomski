ArrayList<String> arrTblNames = new ArrayList<String>();
Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

    if (c.moveToFirst()) {
        while ( !c.isAfterLast() ) {
            arrTblNames.add( c.getString( c.getColumnIndex("name")) );
            c.moveToNext();
        }
    }