for (int i = 0; i < 99; i++) {
            webcamCursor.moveToPosition(i);
            float lat = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lat")));
            float lon = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lon")));
            GeoPoint gp = new GeoPoint((int) (lat / 10), (int) (lon / 10));
            myOverlay1.addPoint(gp);
        }
        for (int i = 100; i < 199; i++) {
            webcamCursor.moveToPosition(i);
            float lat = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lat")));
            float lon = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lon")));
            GeoPoint gp = new GeoPoint((int) (lat / 10), (int) (lon / 10));
            myOverlay2.addPoint(gp);
        }
        for (int i = 200; i < 299; i++) {
            webcamCursor.moveToPosition(i);
            float lat = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lat")));
            float lon = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lon")));
            GeoPoint gp = new GeoPoint((int) (lat / 10), (int) (lon / 10));
            myOverlay3.addPoint(gp);
        }
        for (int i = 300; i < 399; i++) {
            webcamCursor.moveToPosition(i);
            float lat = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lat")));
            float lon = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lon")));
            GeoPoint gp = new GeoPoint((int) (lat / 10), (int) (lon / 10));
            myOverlay4.addPoint(gp);
        }
        for (int i = 400; i < 499; i++) {
            webcamCursor.moveToPosition(i);
            float lat = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lat")));
            float lon = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lon")));
            GeoPoint gp = new GeoPoint((int) (lat / 10), (int) (lon / 10));
            myOverlay5.addPoint(gp);
        }
        for (int i = 500; i < webcamCursor.getCount(); i++) {
            webcamCursor.moveToPosition(i);
            float lat = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lat")));
            float lon = Float.valueOf(webcamCursor.getString(webcamCursor
                    .getColumnIndex("Lon")));
            GeoPoint gp = new GeoPoint((int) (lat / 10), (int) (lon / 10));
            myOverlay6.addPoint(gp);
        }
        System.out.println("**TIME**" + (System.currentTimeMillis() - t));

        mMap.getOverlays().add(myOverlay1);
        mMap.getOverlays().add(myOverlay2);
        mMap.getOverlays().add(myOverlay3);
        mMap.getOverlays().add(myOverlay4);
        mMap.getOverlays().add(myOverlay5);
        mMap.getOverlays().add(myOverlay6);