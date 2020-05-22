...
    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
    int hourIndex = cursor.getColumnIndex(DBHelper.KEY_HOUR);
    int dateIndex = cursor.getColumnIndex(DBHelper.KEY_DATE);
    String name = cursor.getString(nameIndex);
    String hour = cursor.getString(hourIndex);
    String date = cursor.getString(dateIndex);
  ...