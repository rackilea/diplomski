LatLng locationSF = new LatLng(37.7577, -122.4376);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.7577, -122.4376), 12));

        List<LatLng> points = new ArrayList<LatLng>();
        points.add(new LatLng(locationSF.latitude-2, locationSF.longitude-2));
        points.add(new LatLng(locationSF.latitude-2, locationSF.longitude+2));
        points.add(new LatLng(locationSF.latitude+2, locationSF.longitude+2));
        points.add(new LatLng(locationSF.latitude+2, locationSF.longitude-2));


        List<LatLng> hole = new ArrayList<LatLng>();
        float p = 360/360;
        float d =0;
        for(int i=0; i < 360; ++i, d+=p){
            hole.add(SphericalUtil.computeOffset(locationSF, 5000, d));
        }

        mMap.addPolygon(new PolygonOptions()
                .addAll(points)
                .addHole(hole)
                .strokeWidth(0)
                .fillColor(Color.argb(150, 0, 0, 0)));