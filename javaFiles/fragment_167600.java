public void reloadMarkers() {

    MaBase maBaseSQLite = new MaBase(MainActivity.this, NOM_BDD, null, 1);
    SQLiteDatabase db = maBaseSQLite.getWritableDatabase();
    Cursor c = db.query(TABLE_GEOPOINT, new String[] { COL_ID, COL_LONG,
            COL_LAT }, null, null, null, null, null, null);

    int col = c.getCount(); // col=0 pas de enregistrement qui verifie la
    // condition
    if (col == 0) {
        Toast.makeText(MainActivity.this, "Pas de donnees ",
                Toast.LENGTH_LONG).show();
        // effacer le contenue champ login et mot de passe

    } else {

        map.clear();        //Delete all markers in map

        //Add them all again, including the new ones
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            // conversion int to string casting
            String id = "" + c.getInt(0);
            String longitude = c.getString(1);
            String latitude = c.getString(2);
            Marker marqueur = map.addMarker(new MarkerOptions()
                    .position(
                            new LatLng(Double.parseDouble(latitude),
                                    Double.parseDouble(longitude)))
                    .title("Bonjour Tunis")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.mark2)));
            c.moveToNext();
        }
    }
    c.close();
    db.close();

}