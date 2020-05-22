@Override
public void getModelResponse(List<AllTasksModel> allTasksModels, boolean isLoading) {
    mIsLoading = isLoading;
    mListItems = allTasksModels;
    mPbTab.setVisibility(View.GONE);
    mPbTab2.setVisibility(View.GONE);
    mAdapter = new TabJobsRecyclerAdapter(context, mListItems, this);
    mRecViewTab.setAdapter(mAdapter);
    if (mListItems.size() == 0) {
        mTvNoData.setVisibility(View.VISIBLE);
    } else {
        mTvNoData.setVisibility(View.GONE);
    }
}