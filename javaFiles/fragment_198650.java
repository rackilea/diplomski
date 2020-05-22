try {
    cursor.moveToFirst();
    if(cursor.moveToFirst()){
        do{
            HashMap<String, String> mapObj = new HashMap<String, String>();
            mapObj.put("buf_off_id", cursor.getString(1));

            //...
            arrayListBuffet.add(mapObj);//Add to arraylist onject(One row i each iteration)
        }while(cursor.moveToNext());