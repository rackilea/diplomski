...
    // messages recycler view
    messageRecyclerView = (RecyclerView) mca.findViewById(R.id.messageRecyclerView);

    // layout manager for recycler view
    recyclerViewLayoutManager = new LinearLayoutManager(mca);
    recyclerViewLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    // set this right here
    messageRecyclerView.setLayoutManager(recyclerViewLayoutManager);
    ...