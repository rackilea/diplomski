if(cursor != null){

    if(cursor.moveToFirst()){

        do{

            FingerPrint fps = new FingerPrint();


        fps.setFulname(cursor.getString(cursor.getColumnIndex(KEY_ROW_FPD_NAME)));
        fps.setAge(cursor.getInt(cursor.getColumnIndex(KEY_ROW_FPD_AGE)));
        fps.setGender(cursor.getString(cursor.getColumnIndex(KEY_ROW_FPD_GENDER)));
        fps.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ROW_FPD_ADDRESS)));


        // Adding contact to list

        }while(cursor.moveToNext());
    }
}