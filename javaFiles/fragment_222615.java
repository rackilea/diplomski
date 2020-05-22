public LayoutAdapter(Context context, RecyclerView recyclerView, int layoutId, Cursor c) {
    mContext = context;
    mCursor = c;
    mRecyclerView = recyclerView;
    mLayoutId = layoutId;
}