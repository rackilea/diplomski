private void setAppBarDragging(final boolean newValue) {
    AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
    CoordinatorLayout.LayoutParams params = 
            (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
    AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
    behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
        @Override
        public boolean canDrag(AppBarLayout appBarLayout) {
            return newValue;
        }
    });
    params.setBehavior(behavior);
}