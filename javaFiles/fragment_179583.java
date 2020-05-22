mRecyclerView.setHasFixedSize(true);

    // use a linear layout manager
    mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    mRecyclerView.setLayoutManager(mLayoutManager);

    // specify an adapter (see also next example)
    mAdapter = new DemoSlidesAdapter(getApplicationContext());
    mRecyclerView.setAdapter(mAdapter);

    final SnapHelper snapHelper = new LinearSnapHelper();
    snapHelper.attachToRecyclerView(mRecyclerView);

    mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                View centerView = snapHelper.findSnapView(mLayoutManager);
                int pos = mLayoutManager.getPosition(centerView);
                Log.e("Snapped Item Position:",""+pos);
            }
        }
    });