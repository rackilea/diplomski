mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
    public void onItemRangeInserted(int positionStart, int itemCount) {
        int totalNumberOfItems = adapter.getItemCount();
        Log.d(TAG, String.valueOf(totalNumberOfItems));
        if(totalNumberOfItems == 0) {
            recyclerView.setVisibility(View.GONE);
            emptyInfoTextView.setVisibility(View.VISIBLE);
        }
    }
});