mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

        @Override
        public void onMapClick(LatLng point) {

            for (PolyMarkerObject pmObj : polyMarkerList) {
                //only add Marker if there is not one already inside the Polygon
                if (PolyUtil.containsLocation(point, pmObj.polygon.getPoints(), false)) {
                    if (pmObj.marker == null) {

                        //Add Marker to current Polygon
                        Marker newMarker = mMap.addMarker(new MarkerOptions()
                                .position(point)
                                .title("test")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                        pmObj.marker = newMarker;
                        Log.v("Marker", "ADDing Marker");
                        break;
                    }

                }
            }
        }
    });