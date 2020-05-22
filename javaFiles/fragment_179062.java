refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // call your Refresh method here
                mswipeRefreshLayout.setRefreshing(false);
            }
});