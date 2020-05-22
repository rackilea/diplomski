static final LatLng SomePos = new LatLng(37.7796354, -122.4159606);

    try {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        }
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);
        googleMap.setTrafficEnabled(false);
        googleMap.setIndoorEnabled(false);
        googleMap.setBuildingsEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SomePos));
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                .target(googleMap.getCameraPosition().target)
                .zoom(17)
                .bearing(30)
                .tilt(45)
                .build()));

        myMarker = googleMap.addMarker(new MarkerOptions()
                .position(SomePos)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
                .title("Hello world"));


        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick(Marker arg0) {

                final LatLng startPosition = myMarker.getPosition();
                final LatLng finalPosition = new LatLng(37.7801569,-122.4148528);
                final Handler handler = new Handler();
                final long start = SystemClock.uptimeMillis();
                final Interpolator interpolator = new AccelerateDecelerateInterpolator();
                final float durationInMs = 3000;
                final boolean hideMarker = false;

                handler.post(new Runnable() {
                    long elapsed;
                    float t;
                    float v;

                    @Override
                    public void run() {
                        // Calculate progress using interpolator
                        elapsed = SystemClock.uptimeMillis() - start;
                        t = elapsed / durationInMs;
                        v = interpolator.getInterpolation(t);

                        LatLng currentPosition = new LatLng(
                                startPosition.latitude*(1-t)+finalPosition.latitude*t,
                                startPosition.longitude*(1-t)+finalPosition.longitude*t);

                        myMarker.setPosition(currentPosition);

                        // Repeat till progress is complete.
                        if (t < 1) {
                            // Post again 16ms later.
                            handler.postDelayed(this, 16);
                        } else {
                            if (hideMarker) {
                                myMarker.setVisible(false);
                            } else {
                                myMarker.setVisible(true);
                            }
                        }
                    }
                });

                return true;

            }

        });

    } catch (Exception e) {
        e.printStackTrace();
    }