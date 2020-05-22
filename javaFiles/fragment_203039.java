mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

        @Override
        public void onMapClick(LatLng point) {

            for (Polygon pObj : polyList) {
                //find Polygon user tapped inside of
                if (PolyUtil.containsLocation(point, pObj.getPoints(), false)) {
                    //first case, no Marker
                    if (marker == null) {

                        //Add Marker to current Polygon
                        marker = mMap.addMarker(new MarkerOptions()
                                .position(point)
                                .title("test")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                        Log.v("Marker", "ADDing first Marker");
                        break;
                    }
                    else if (!PolyUtil.containsLocation(marker.getPosition(), pObj.getPoints(), false)) {
                        //Marker exists already in a different Polygon
                        //remove Marker from previous Polygon
                        marker.remove();
                        //Add Marker to current Polygon
                        marker = mMap.addMarker(new MarkerOptions()
                                .position(point)
                                .title("test")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                        Log.v("Marker", "Moving Marker to new Polygon");
                        break;
                    }

                }
            }
        }
    });