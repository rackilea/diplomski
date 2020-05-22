private void getParentScroller(Context context) {
    if (mScroller != null) return;
    mScroller = new OverScroller(context);
    try {
        Class<?> reflex_class = getClass().getSuperclass().getSuperclass();
        Field fieldScroller = reflex_class.getDeclaredField("mScroller");
        fieldScroller.setAccessible(true);
        fieldScroller.set(this, mScroller);
    } catch (Exception e) {
    }
  }

@Override
public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed, int type) {
    if (mScroller != null) {
        if (mScroller.computeScrollOffset()) {
            mScroller.abortAnimation();
        }
    }
    if (type == ViewCompat.TYPE_NON_TOUCH && getTopAndBottomOffset() == 0) {
        ViewCompat.stopNestedScroll(target, type);
    }
    super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
}