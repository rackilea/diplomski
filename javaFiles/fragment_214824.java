@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
        mDatabaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Places places = dataSnapshot.getValue(Places.class);
                placesList.add(places);
                placeRecyclerAdapter = new PlaceRecyclerAdapter(MainActivity.this,placesList);
                recyclerView.setAdapter(placeRecyclerAdapter);
                placeRecyclerAdapter.notifyDataSetChanged();
            }
    }