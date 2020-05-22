mapFragment = new SupportMapFragment() {
                @Override
                public void onActivityCreated(Bundle savedInstanceState) {
                    super.onActivityCreated(savedInstanceState);
                    googleMap = mapFragment.getMap();
                    if (googleMap != null) {
                        googleMap.getUiSettings().setZoomGesturesEnabled(true);
                        googleMap.setOnMapClickListener(BookACabFragment.this);
                        googleMap.setOnMarkerDragListener(BookACabFragment.this);
                        googleMap.setOnMarkerClickListener(BookACabFragment.this);
                        //googleMap.setMyLocationEnabled(true);

                        pickedLocation = GeoUtils.getLocationFromPreferences(getActivity());
                    }
                }

            };