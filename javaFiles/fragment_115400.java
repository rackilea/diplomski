new SwipeDismissListViewTouchListener.DismissCallbacks() {

    @Override
    public boolean canDismiss(int position) {
        return position == 0;
    }

    ...

});