//-- Draw all list of base account
    SQLiteDatabase db = openOrCreateDatabase(getResources().getString(R.string.databasename),MODE_PRIVATE,null);
    Cursor dbv_accounts = db.rawQuery("SELECT * FROM accounts WHERE type='BASE'",null);
    //-- Make ArrayList and push every needed row value
    ArrayList<CharSequence> ALaccounts_list = new ArrayList<CharSequence>();
    while (dbv_accounts.moveToNext())
    {
        String row = dbv_accounts.getString(dbv_accounts.getColumnIndex("name"));
        ALaccounts_list.add(row);
    }
    db.close();