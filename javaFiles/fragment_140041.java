mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
        @Override
        public void onRefresh(){
            listcontent.clear(); // prevent repeating data 
            new GetContacts().execute();
            mSwipeRefreshLayout.setRefreshing(false);
        }
    });
    new GetContacts().execute();  // load before refresh 
    return myFragmentView;
}