private void setupRecyclerView(List<Item> itemsList) {

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setAdapter(new MyCardsAdapter(itemsList, this));
    }