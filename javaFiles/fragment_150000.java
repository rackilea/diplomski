mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
    mSwipeRefreshLayout.setOnRefreshListener(this);
    mSwipeRefreshLayout.post(new Runnable() {
                                @Override
                                public void run() {
                                    mSwipeRefreshLayout.setRefreshing(true);
                                    refresh();
                                }});

//here refreshed Item
   //getLoaderManager().initLoader(0, null, this);

    if (savedInstanceState == null) {
        refresh();
    }