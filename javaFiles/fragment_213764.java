@Override
public void getModelResponse(List<AllTasksModel> allTasksModels, boolean isLoading) {
    mIsLoading = isLoading;
    mListItems = allTasksModels;
    mPbTab.setVisibility(View.GONE);
    mPbTab2.setVisibility(View.GONE);
    if (mListItems.size() == 0) {
        mTvNoData.setVisibility(View.VISIBLE);
    } else {
        mAdapter = new TabJobsRecyclerAdapter(context, mListItems, this);
        mRecViewTab.setAdapter(mAdapter);
    }
}