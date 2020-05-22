List<LatLng> newPolygon = new ArrayList<>();
    //set up the points in the Polygon.......

    Polygon p = mMap.addPolygon(new PolygonOptions()
            .addAll(newPolygon)
            .strokeColor(Color.RED)
            .fillColor(Color.BLUE));

    polyList.add(p);