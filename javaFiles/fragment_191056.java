// ListView.java
public void setAdapter(ListAdapter adapter) {
    ...
    // This is the only call to getViewTypeCount()
    mRecycler.setViewTypeCount(mAdapter.getViewTypeCount());
    ...
}

// AbsListView.java
public void setViewTypeCount(int viewTypeCount) {
    ...
    // Here it creates the array of given size
    ArrayList<View>[] scrapViews = new ArrayList[viewTypeCount];
    ...
    mViewTypeCount = viewTypeCount;
    mScrapViews = scrapViews;
}

void addScrapView(View scrap, int position) {
    final int viewType = lp.viewType;
    ...
    // And here you get ArrayIndexOutOfBoundsException
    mScrapViews[viewType].add(scrap);
}