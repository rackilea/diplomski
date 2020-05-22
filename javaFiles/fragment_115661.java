recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (dy > 0) {
            // Scrolling up
        } else {
            // Scrolling down
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        if (newState == AbsListView.OnScrollListener. SCROLL_STATE_IDLE) {
          //you can change the position according to your need 
       if(recyclerView.getLayoutManager().findFirstVisibleItemPosition()<2)
          {
           fabAddNew.hide();
          }  
         else{
           fabAddNew.show();
          }              
        } 
    }
});