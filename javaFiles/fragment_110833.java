public long getFehlzeitenSum() {
    long result = 0;
    Cursor c = mDb.query(DATABASE_TABLE, 
      new String[] { "sum(" + KEY_Time + ")" },
      null, 
      null, 
      null /* you may add a GROUP BY attribute (e.g. KEY_Test) here */,
      null /* and here a HAVING for your group-by-clause */, 
      null);
    if (c.moveToFirst()) {
        result = c.getLong(0);
    }
    c.close();
    return result;
}