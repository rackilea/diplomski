mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

        @Override
        public void onMapClick(LatLng point) {

            if (PolyUtil.containsLocation(point, polygonList, false)) {

                if (marker == null) {
                    //only add Marker if there is not one already inside the Polygon
                    marker = mMap.addMarker(new MarkerOptions()
                            .position(point)
                            .title("test")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                    Log.v("Marker", "ADDing Marker");

                }

            }
        }
    });