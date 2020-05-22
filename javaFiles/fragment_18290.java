PullToRefreshListView mPullRefreshListView = 
  (PullToRefreshListView) findViewById(R.id.listview);
mPullRefreshListView.setMode(Mode.BOTH);    // mode refresh for top and bottom
mPullRefreshListView.setShowIndicator(false); //disable indicator
mPullRefreshListView.setPullLabel("Loading");

 mPullRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
          //do something when refresh
});