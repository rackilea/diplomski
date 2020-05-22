void sauver_point() {

    MaBase maBaseSQLite = new MaBase(MainActivity.this, NOM_BDD, null, 1);
    SQLiteDatabase db = maBaseSQLite.getWritableDatabase();
    ContentValues values = new ContentValues();
    // values.put(COL_ID , "1");
    values.put(COL_LAT, "36.830722");
    values.put(COL_LONG, "10.165672");

    long id = db.insert(TABLE_GEOPOINT, null, values);  //Get the db id of the new inserted marker

    //You can keep the id in an array and then query your database looking for those specific ids.

    //The just add them to your map. Just don't clear the map his time! Or you will loose the old ones

    db.close();

}