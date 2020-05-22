private int radius = 40;
    private Boolean userFound = false;
    private String userLocationID;
    private ArrayList<String> mUserIDLocation;
    final UserLocation userLocation = new UserLocation();
    public void getUserLocation() {
        final DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        final GeoFire geoFire = new GeoFire(mRef.child("user_location"));
        mUserIDLocation = new ArrayList<String>();

        swipe.setRefreshing(false);

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener((Activity) MainActivity.this, new OnSuccessListener<Location>() {

            @Override
            public void onSuccess(Location location) {

                if (location != null) {
                    //Toast.makeText(this, "UserLocation " + location.toString(), Toast.LENGTH_SHORT ).show();
                    //final Location userLocation = location;
                    Log.d(TAG, "onSuccess: UserLocation" + location);
                    Log.d(TAG, "onSuccess: UserLocation Latitude " + location.getLatitude());

                    String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();




                    geoFire.setLocation(user_id, new GeoLocation(location.getLatitude(), location.getLongitude()), new GeoFire.CompletionListener() {
                        @Override
                        public void onComplete(String key, DatabaseError error) {

                        }
                    });

                    GeoQuery geoQuery = geoFire.queryAtLocation(new GeoLocation(location.getLatitude(), location.getLongitude()), radius);


                    geoQuery.addGeoQueryDataEventListener(new GeoQueryDataEventListener() {
                        @Override
                        public void onDataEntered(DataSnapshot dataSnapshot, GeoLocation location) {

                            Log.d(TAG, "onDataEntered: datasnapshot " + dataSnapshot);

                            mUserIDLocation.add(dataSnapshot.getKey());


                        }

                        @Override
                        public void onDataExited(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onDataMoved(DataSnapshot dataSnapshot, GeoLocation location) {

                        }

                        @Override
                        public void onDataChanged(DataSnapshot dataSnapshot, GeoLocation location) {

                        }

                        @Override
                        public void onGeoQueryReady() {

                            mFollowing = mUserIDLocation;

                            Log.d(TAG, "onGeoQueryReady: mFollowing users " + mFollowing);

                            getPost();
                        }

                        @Override
                        public void onGeoQueryError(DatabaseError error) {

                        }
                    });
                }
            }
        });

    }