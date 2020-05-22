String[] columns = {PERSON_COLUMN_ID, PERSON_COLUMN_NAME};
    Cursor res = db.query(PERSON_TABLE_NAME, columns, null, null, null,null, null);
    res.moveToFirst();
    do{
        res.moveToNext();}
    while(res.getString(0) != id)
    return res.getString(1);