public ArrayList<String[]> getWeekUni() {
    SQLiteDatabase db = helper.getWritableDatabase();

    String[] columns = { MenuDataBase.SOPA, MenuDataBase.FONDO1,
            MenuDataBase.REFRESCO, MenuDataBase.CALORIAS, };

    ArrayList<String[]> weekdays = new ArrayList<String[]>();



    Cursor cursor = db.query(MenuDataBase.TABLE_UNI, columns, null, null,
            null, null, null);

    while (cursor.moveToNext()) {
        // cursor.moveToNext(); //<-- You already did that one line above!!!!
        String[] rowDay = new String[4]; //init here to create a new object and add it not to override existing object references!!!

        int index1 = cursor.getColumnIndex(MenuDataBase.SOPA);
        int index2 = cursor.getColumnIndex(MenuDataBase.FONDO1);
        int index3 = cursor.getColumnIndex(MenuDataBase.REFRESCO);
        int index4 = cursor.getColumnIndex(MenuDataBase.CALORIAS);
        rowDay[0] = cursor.getString(index1);
        rowDay[1] = cursor.getString(index2);
        rowDay[2] = cursor.getString(index3);
        rowDay[3] = cursor.getString(index4);

        Log.d("TEST", rowDay[0]+" Get week");
            Log.d("TEST", rowDay[1]+" Get week");

        //int i = 0;
        weekdays.add(rowDay);

        Log.d("TEST",Integer.toString(weekdays.size()));
        // not i to get last element, get last element with weekdays.size() - 1
        Log.d("TEST", weekdays.get(weekdays.size() - 1)[0].toString());
        Log.d("TEST", weekdays.get(weekdays.size() - 1)[1].toString());
        // i++;
    }

   //To get All entries make it that way
   for(String[] item : weekdays){
        Log.d("TEST", "" + item[0]);
        Log.d("TEST", "" + item[1]);
        Log.d("TEST", "" + item[2]);
        Log.d("TEST", "" + item[3]);
   }

    cursor.close();
    db.close();

    return weekdays;
}