public void loadTrack() {
SQLiteDatabase db1 = waypoints.getWritableDatabase();
Cursor trackCursor = db1.query(TABLE_NAME, FROM, "trackidfk=1", null, null, null,ORDER_BY); 

    trackCursor.moveToFirst();
    do {
        Double lat = trackCursor.getDouble(2);
        Double lon = trackCursor.getDouble(1);
        //overlay.addGeoPoint( new GeoPoint( (int)(lat*1E6),  (int)(lon*1E6)));
        System.out.println(lon);
        System.out.println(lat);
    } while (trackCursor.moveToNext());
}