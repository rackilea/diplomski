public boolean checkAppointmentExist(String name){
        booolean isExist = false;

        String selection = COLUMN_TITLE + " = ? ";
        String[] selectionArgs = new String[]{name};
        Cursor cursor = database.query(TABLE_APPOINTMENTS, null, selection, selectionArgs, null, null, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
               isExist = true;
            }
        }

   return isExist;

}


public void addAppointment(Appointment app){

      if(!checkAppointmentExist(app.get_title())){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DAY, app.get_day());
        values.put(COLUMN_MONTH, app.get_month());
        values.put(COLUMN_YEAR, app.get_year());
        values.put(COLUMN_TITLE, app.get_title()); // need to check that string being entered isn't already a unique entry
        values.put(COLUMN_TIME, app.get_time());
        values.put(COLUMN_DESCRIPTION, app.get_details());
        db.insert(TABLE_APPOINTMENTS, null, values);
        db.close();
      }

    }