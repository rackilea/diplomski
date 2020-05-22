SQLiteDatabase db1 = tracks.getWritableDatabase();
    ContentValues tracksvalues = new ContentValues();
    tracksvalues.put(COL1, '1');
    tracksvalues.put(COL2, '2');
    Long insertid=db1.insertOrThrow(TABLE_NAME1, null, tracksvalues);

    if (insertid!=-1) {

        SQLiteDatabase db2 = waypoints.getWritableDatabase();
        ContentValues waypointvalues = new ContentValues();
        waypointvalues.put(LONGITUDE, loc.getLongitude());
        waypointvalues.put(LATITUDE, loc.getLatitude());
        waypointvalues.put(TIME, System.currentTimeMillis());
        waypointvalues.put(TRACK_ID_FK, insertid);
        db2.insertOrThrow(TABLE_NAME2, null, waypointvalues);

    }