@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mRecyclerView = findViewById(R.id.recycler_view);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    mAdapter = new ImageAdapter(MainActivity.this, new ArrayList<>());
    mRecyclerView.setAdapter(mAdapter);

    mDatabaseRef = FirebaseDatabase.getInstance().getReference("Data");

    mDatabaseRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            List<Upload> readUploads = new ArrayList<>();
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                Upload upload = postSnapshot.getValue(Upload.class);
                readUploads.add(upload);
            }
            mAdapter.setUploads(readUploads);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
}