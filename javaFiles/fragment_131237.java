public boolean check_existence(String stud_id) {

        SQLiteDatabase db = this.getWritableDatabase();
        String select = "SELECT * FROM table_name WHERE column_name ='" + stud_id;

        Cursor c = db.rawQuery(select, null);

        if (c.moveToFirst()) {

            Log.d(TAG,"User exits");
            return true;
        }

        if(c!=null) {

            c.close();
        }
        db.close();
        return false;
}