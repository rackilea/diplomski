LinearLayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
mLayoutManager.setReverseLayout(true);
mLayoutManager.setStackFromEnd(true);
// And now set it to the RecyclerView
mRecyclerView.setLayoutManager(mLayoutManager);
mRecyclerView.setAdapter(yourAdapter);