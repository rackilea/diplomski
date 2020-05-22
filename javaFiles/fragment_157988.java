@Override
public void onScrollChanged(ScrollViewExt scrollView, int x, int y, int oldx, int oldy) {
    // We take the last son in the scrollview
    View view = (View) scrollView.getChildAt(scrollView.getChildCount() - 1);
    int diff = (view.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));

    // if diff is zero, then the bottom has been reached
    if (diff == 0) {
        // do stuff
    }
}