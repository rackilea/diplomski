if (c.moveToFirst()) {
   do {
       courseName.setText(c.getString(1));
       courseCode.setText(c.getString(2));
       lecturer.setText(c.getString(3));
       creditHour.setText(c.getString(4));
       startTime.setText(c.getString(5));

   } while (c.moveToNext());