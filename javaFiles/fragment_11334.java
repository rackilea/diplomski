public List<String> getQuotes(String id) {
    List<String> list = new ArrayList<>();
    Integer value;


    if(id != null)
    {
        Cursor cursor = database.rawQuery("SELECT org_name FROM org_name WHERE category_id = \""+ id +"\"" , null);
       /* Cursor cursor = database.rawQuery("SELECT org_name FROM org_name WHERE category_id="+a, null);*/
       /*Cursor cursor = database.rawQuery("SELECT org_name FROM org_name WHERE category_id='ID_EXTRA'", null);*/
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
            cursor.close();
        }
    }

  /*  if (passedVar != null) {


    }*/

    return list;
}