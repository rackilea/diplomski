public void addClientInformations (Integer CIN,String name, String surname,String email,Integer phone,String password, String vehType,String vehModel){

        SQLiteDatabase db=getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(TablesDB.NewClientInfo.COL_1,CIN );
        contentValues.put(TablesDB.NewClientInfo.COL_2,name );
        contentValues.put(TablesDB.NewClientInfo.COL_3,surname );
        contentValues.put(TablesDB.NewClientInfo.COL_4,email );
        contentValues.put(TablesDB.NewClientInfo.COL_5,phone );
        contentValues.put(TablesDB.NewClientInfo.COL_6,password );
        contentValues.put(TablesDB.NewClientInfo.COL_7,vehType );
        contentValues.put(TablesDB.NewClientInfo.COL_8,vehModel );
        db.insert(TablesDB.NewClientInfo.TABLE_NAME,null,contentValues);

        Log.e("Database operations","One row inserted...");

    }