LatLng  latpoint;

MAP.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

            @Override
            public void onMapLongClick(LatLng point) {
                // TODO Auto-generated method stub

                // MAP.clear();
                if (marker != null) {
                    marker.remove();
                }
                latpoint = point;
                marker = MAP.addMarker(new MarkerOptions()
                        .position(
                                new LatLng(latpoint.latitude,
                                        latpoint.longitude))
                        .title(point.toString()).draggable(true)
                        .visible(true));

            }

        });