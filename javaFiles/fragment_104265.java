mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        final int totalItemCount = mLinearLayoutManager.getItemCount();
        final int visibleItemCount = mLinearLayoutManager.getChildCount();
        final int firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

        if (!mLoadingStarted && (totalItemCount - visibleItemCount <= firstVisibleItem)) {
            mLoadingStarted = true;

            // fetch more data
        }
    }
});