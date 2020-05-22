mHandler = new Handler();
 listview.setOnScrollListener(new EndlessScrollListener() {
        @Override
        public void onLoadMore(int page, int totalItemsCount) {
                 if(count<mainArrayList.size()-1)
                  {
                     if(adapter !=null){
            count++;                       
            if(!isLoadingMore){
                             isLoadingMore=true;
                             mHandler.postDelayed(loadMoreRunnable,1000); 
                          } 
                      }
                  } 
        }
        });
    }

     Runnable loadMoreRunnable = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
         if(count<mainArrayList.size())
                   {
                     if(adapter !=null){
                      count++;                       
                      adapter.addAll(mainArrayList.get(count));
                      mHandler.removeCallbacks(loadMoreRunnable);
                      isLoadingMore=false;
                      }
                  } 
        }
    };