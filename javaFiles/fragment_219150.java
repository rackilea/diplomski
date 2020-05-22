@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.hosting_trip);

    mOwnTripList = (RecyclerView) findViewById(R.id.host_trip_list);
    mOwnTripList.setHasFixedSize(true);
    mOwnTripList.setLayoutManager(new LinearLayoutManager(this));

 mPostIdRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            comPostArrayList.clear();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                PostId postId = snapshot.getValue(PostId.class);
                    tripUniqueId = postId.getPostId();
                Log.d("$$$$$$$$$$$$$" , tripUniqueId);


    adapter = new YourHostAdapter( 
             comPostArrayList,this.getApplicationContext());

        mLastRef = FirebaseDatabase.getInstance().getReference().child("comPostsCopy")
                   .child(tripUniqueId);

        mLastRef.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(DataSnapshot dataSnapshot) {


         OwnHostTripItem ownHostTripPost = dataSnapshot
                                         .getValue(OwnHostTripItem.class);
              comPostArrayList.add(ownHostTripPost);
            Log.d("%%%%%",comPostArrayList.get(0).getTitle());

        }

         @Override
         public void onCancelled(DatabaseError databaseError) {

            }
         });

            }
         adapter.notifyDataSetChanged();

         mOwnTripList.setAdapter(adapter);

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });





} 
  }