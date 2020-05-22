//delete a row by string name
    public boolean deleteRow(String name) {
         String where = KEY_NAME + "=?";
            return db.delete(DATABASE_TABLE, where, new String[] { name } ) != 0;

    }

    public void deleteAll() {
        Cursor c = getAllRows();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()) {
            do {
                deleteRow(c.getString((int) rowId));                
            } while (c.moveToNext());
        }
        c.close();
    }