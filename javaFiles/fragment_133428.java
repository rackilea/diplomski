mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);

                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap map) {
                        googleMap = map;

                        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        googleMap.setMyLocationEnabled(false); // false to disable
                        googleMap.setOnMarkerClickListener(onMarkerClick);
                        googleMap.setOnInfoWindowClickListener(onInfoWindowClick);
                        googleMap.getUiSettings().setZoomControlsEnabled(true);// Display Zoom Controls
                        googleMap.setMyLocationEnabled(true);// Display My Location Control
                    }
                });
            }