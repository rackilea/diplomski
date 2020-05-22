public List<TheModelClass> getAllNameOfTheList() {
        List<TheModelClass> NameOfTheList = new ArrayList<TheModelClass>();
        String selectQuery = "SELECT  * FROM " + TABLE_ONE;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {

                TheModelClass SomeName = new TheModelClass();
                SomeName.setValueNumberOne(c.getString(c.getColumnIndex(KEY_COLUMN_ONE)));
                SomeName.setValueNumberTwo(c.getInt(c.getColumnIndex(KEY_COLUMN_TWO)));
                SomeName.setValueNumberThree(c.getDouble(c.getColumnIndex(KEY_COLUMN_THREE)));
                SomeName.setValueNumberFour(c.getLong(c.getColumnIndex(KEY_COLUMN_FOUR)))
                .
                .
                .
                SomeName.setValueNumberX(c.getSomeDataTypeBasedOnTheTypeYouHaveSetInTheModelClass(c.getColumnIndex(THE_COLUMN)))
                // add
                NameOfTheList.add(SomeName);
            } while (c.moveToNext());
        }
        // db.close();
        c.close();
        return NameOfTheList;
    }