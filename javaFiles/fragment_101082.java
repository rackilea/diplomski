final int bottom = collapsible_content.getBottom();
final int listViewHeight = mRecyclerView.getHeight();
if (bottom > listViewHeight) {
    final int top = collapsible_content.getTop();
    if (top > 0) {
        mRecyclerView.smoothScrollBy(0, Math.min(bottom - listViewHeight + mRecyclerView.getPaddingBottom(), top));
    }
}