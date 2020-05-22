private class ListFragmentSwipeRefreshLayout extends SwipeRefreshLayout {

    public ListFragmentSwipeRefreshLayout(Context context) {
        super(context);
    }

    /**
     * As mentioned above, we need to override this method to properly signal when a
     * 'swipe-to-refresh' is possible.
     *
     * @return true if the {@link android.widget.ListView} is visible and can scroll up.
     */
    @Override
    public boolean canChildScrollUp() {
        final ListView listView = getListView();
        if (listView.getVisibility() == View.VISIBLE) {
            return canListViewScrollUp(listView);
        } else {
            return false;
        }
    }

}

/**
 * Utility method to check whether a {@link ListView} can scroll up from it's current position.
 * Handles platform version differences, providing backwards compatible functionality where
 * needed.
 */
private static boolean canListViewScrollUp(ListView listView) {
    if (android.os.Build.VERSION.SDK_INT >= 14) {
        // For ICS and above we can call canScrollVertically() to determine this
        return ViewCompat.canScrollVertically(listView, -1);
    } else {
        // Pre-ICS we need to manually check the first visible item and the child view's top
        // value
        return listView.getChildCount() > 0 &&
                (listView.getFirstVisiblePosition() > 0
                        || listView.getChildAt(0).getTop() < listView.getPaddingTop());
    }
}