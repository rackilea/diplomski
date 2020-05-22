public Cursor readEntry() {

            SQLiteDatabase db = helper.getWritableDatabase();

            String[] allColumns = new String[] { data.NAME,
                    data._STATUS, data.WEIGHT, data.DATE};

            Cursor c = db.query(data.TABLE_NAME, allColumns, null, null, null,
                    null, null);

            if (c != null) {
                c.moveToFirst();
            }
            return c;

        }

        public boolean deleteRow(String name) {

            SQLiteDatabase db = helper.getWritableDatabase();
            String where = data.NAME + " = " + "'" + name + "'";
            return db.delete(data.TABLE_NAME, where, null) != 0;
        }

        public void DeleteAll(){

            Cursor c = readEntry();
            long id = c.getColumnIndexOrThrow(data.NAME);
            if (c.moveToFirst()) {
                do {
                    deleteRow(c.getString((int) id));
                } while (c.moveToNext());
            }
            c.close();

        }