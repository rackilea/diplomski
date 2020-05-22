@Override
    public void onLocationChanged(Location loc) {
        double lati = loc.getLatitude();
        double longi = loc.getLongitude();

        //User's current location
        ParseGeoPoint point = new ParseGeoPoint(lati, longi);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Locations");
        query.whereWithinKilometers("location", point, 100);
        query.findInBackground(new FindCallback<ParseObject>() { ... });
    }