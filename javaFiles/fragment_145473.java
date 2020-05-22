Cursor c= vivzHelper.getAllRows();    
    String[] from = new String[]{ vivzHelper.NAME};    
    int[] to = new int[] {R.id.textView}; // textView of custom row.   
    SimpleCursorAdapter cursorAdapter;
 cursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.cutsom_row, c, from, to, 0);    
    ListView thislist=(ListView)findViewById(R.id.listView);    
    thislist.setAdapter(cursorAdapter);    


    public Cursor getAllRows( ) {
    String where = null;
    SQLiteDatabase db = helper.getReadableDatabase();
    String[] columns = { VivzHelper.UID,VivzHelper.NAME};
    Cursor c = db.query(VivzHelper.TABLE_NAME, columns, null, null, null, null, null);
    if (c != null) {
        c.moveToFirst();
    }
    return c;
    }