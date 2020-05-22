public int pageNumber = 0;
private boolean loading = true;
int pastVisiblesItems, visibleItemCount, totalItemCount;

mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if(dy > 0) {
             // Check for scroll down
            visibleItemCount = mLayoutManager.getChildCount();
            totalItemCount = mLayoutManager.getItemCount();
            pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

            if (loading) {
                if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                    loading = false;
                    Log.v("...", "Last image reached");
                    // Set the pageNumber here. 
                    adapter.setPageNumber(pageNumber + 1);
                    pageNumber += 1; 
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
});