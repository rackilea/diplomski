listView.setOnScrollListener(new OnScrollListener(){

   @Override
   public void onScrollStateChanged(AbsListView view, int scrollState) {}

   @Override
   public void onScroll(AbsListView view, int firstVisibleItem,
     int visibleItemCount, int totalItemCount) {

   int lastInScreen = firstVisibleItem + visibleItemCount;    
   if((lastInScreen == totalItemCount) && !(loadingMore)){     
    getData();
   }
   }
  });