public void getWarehouse(){
  .....
    //Some retrofit calls 
  .....
    mRecyclerView = (RecyclerView) mActivity.findViewById(R.id.staggering_grid);
    mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    mAdapter = new StaggeredGridAdapter(mContext);
    mAdapter.addItems(response);
    mRecyclerView.setAdapter(mAdapter);
}