private Firebase mRef;
    private Firebase mUserRef;
    private String mUserId;
    List<List<String>> latitudeNlongitude = new ArrayList<>();


    //  FirebaseRecyclerAdapter<MyLatLng123, LatLngViewHolderBack2> mAdapter;
    FirebaseRecyclerAdapter<MyWaypoint, LatLngViewHolderBack2> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mRef = new Firebase(Constants.FIREBASE_URL);
        if (mRef.getAuth() == null) {
            loadLoginView();
        }


        try {
            mUserId = mRef.getAuth().getUid();
        } catch (Exception e) {
            loadLoginView();
        }


        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        mRecyclerView.setHasFixedSize(false);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setReverseLayout(false);
        mRecyclerView.setLayoutManager(manager);


        // https://todoapprj.firebaseio.com/users/1a96a633-7e67-41b8-9aa7-c70d4b7eb59c/waypoints
        final String userUrl = Constants.FIREBASE_URL + "/users/" + mUserId + "/waypoints";
        mUserRef = new Firebase(userUrl);


        if (mUserRef != null) {
            mUserRef.addValueEventListener(new ValueEventListener() {
                //this keeps per-user list of points
                List<MyWaypoint> userWayPointsList = new ArrayList<MyWaypoint>();

                @Override
                public void onDataChange(DataSnapshot wayPointsDataSnapshot) {
                    if (wayPointsDataSnapshot.getChildrenCount() > 0) {


                        for (DataSnapshot wayPointsSnapshotChild : wayPointsDataSnapshot.getChildren()) {
                            Log.i("FireBaseTester", "For-Loop :: wayPointsSnapshotChild.getValue() : " + wayPointsSnapshotChild.getValue());
                            if (wayPointsSnapshotChild.getChildrenCount() > 0) {


                                // Temporary list
                                List<String> latLngListTemp = new ArrayList<>();


                                for (DataSnapshot wayPointsChild : wayPointsSnapshotChild.getChildren()) {

                                    //this is where we get the Lat and Lon
                                    double latitude = Double.parseDouble(wayPointsChild.child("latitude").getValue().toString());
                                    double longitude = Double.parseDouble(wayPointsChild.child("longitude").getValue().toString());
                                    Log.i("FireBaseTester", "latitude = " + latitude + " , longitude = " + longitude);

                                    latLngListTemp.add(latitude + ", " + longitude);


                                }

                                // List containing a nested List<List<String>>
                                latitudeNlongitude.add(latLngListTemp);
                            }

                        }

                    }

                    //here you can assign the points to the user
                    Log.i("FireBaseTester", "There are " + userWayPointsList.size() + " Points for User");
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    Log.e("FireBaseTester", "onCancelled - wayPointRef Error is " + firebaseError.getMessage());
                }
            });
        } else {
            Log.i("FireBaseTester", "No WayPoints Data Received");
        }


        mAdapter = new FirebaseRecyclerAdapter<MyWaypoint, LatLngViewHolderBack2>(MyWaypoint.class, R.layout.list_item, LatLngViewHolderBack2.class, mUserRef) {
            @Override
            protected void populateViewHolder(final LatLngViewHolderBack2 latLngViewHolder, MyWaypoint item, final int i) {




                // Retrieves a List from the position (i) of the nested list at onDataChange --- > List<List<String>> latitudeNlongitude
                List<String> latlngListIterator = latitudeNlongitude.get(i);

                // New Empty list for each iteration
                List<String> latLngListTemporary  = new ArrayList<>();

                // Adding items to a new empty list for use in next method with googles api.
                for (String value : latlngListIterator) {
                    latLngListTemporary.add(value);
                }

                // Getting the start location and the endlocation
                String startLatLng = latLngListTemporary.get(0);
                String endLatLng = latLngListTemporary.get(latLngListTemporary .size() - 1);


                // Retrieves the information from googles API in JSON and turns them into POJOS