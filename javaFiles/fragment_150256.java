String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_HOTNESS};
Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
String result = "";

int iRow = c.getColumnIndex(KEY_ROWID);
int iName = c.getColumnIndex(DATABASE_NAME);