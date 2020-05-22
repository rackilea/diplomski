public ArrayList<kovil> Get_Temple() {
    try {
        temple_list.clear();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TEMPLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.getCount()>0)) {
           cursor.moveToFirst(
        do {
            kovil Kovil = new kovil();
            Kovil.setID(Integer.parseInt(cursor.getString(0)));
            Kovil.settemplename(cursor.getString(1)); 
            Kovil.settempletype(cursor.getString(2)); 
            Kovil.setlatitude(cursor.getString(3)); 
            Kovil.setlongitude(cursor.getString(4)); 
            Kovil.setimage_name(cursor.getString(5)); 
            Kovil.setyear_build(cursor.getString(6)); 
            Kovil.setaddress(cursor.getString(7)); 
            Kovil.setcity(cursor.getString(8)); 
            Kovil.setemail(cursor.getString(9)); 
            Kovil.setwebsite(cursor.getString(10)); 
            Kovil.settelephone1(cursor.getString(11)); 
            Kovil.settelephone2(cursor.getString(12));
            Kovil.setDescription(cursor.getString(13));



            // Adding contact to list
            temple_list.add(Kovil);
        } while (cursor.moveToNext());
        }

        // return contact list
        cursor.close();
        db.close();

    } catch (Exception e) {
        // TODO: handle exception
        Log.e("all_temples", "" + e);
    }

    return temple_list;
    }