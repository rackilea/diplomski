// Need to use the Actual ListView when registering
    // for Context Menu
    registerForContextMenu(kfulist);
    newsadapter.notifyDataSetChanged();

    Log.d("List", "position of list = " + position);
    mPullRefreshListView.onRefreshComplete();
    mPullRefreshListView.post(new Runnable()
    {
        @Override
        public void run()
        {
            mPullRefreshListView.getRefreshableView().setSelection(position);
            kfulist.setSelection(position);
        }
    });
    Log.d("List", "List " + kfunews.toString());     

    // [...]
}