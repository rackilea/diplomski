public List<TheModelClass> getTheValue(String SomeValue) {
        List<TheModelClass> NameOfTheList = new ArrayList<TheModelClass>();
        String selectQuery = "SELECT  * FROM " + TABLE_ONE + " where " + KEY_COLUMN_ONE + " = ?";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, new String[] {SomeValue});

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                TheModelClass AnythingYouWantToNameThis = new TheModelClass();
                AnythingYouWantToNameThis.setModelValueNumberOne(c.getString(c.getColumnIndex(KEY_COLUMN_ONE)));
                // add
                NameOfTheList.add(AnythingYouWantToNameThis);
            } while (c.moveToNext());
        }
        //always close the cursor after using it cause it may cause memory leak
        c.close();
        return NameOfTheList;
    }