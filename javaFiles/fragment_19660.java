BaseSwipeListViewListener myBaseSwipeListViewListener0 = new BaseSwipeListViewListener() {
    @Override
    public void onOpened(int position, boolean toRight) {
        onOpenedAdvanced(position, toRight, swipelistview0);
    } 
}

BaseSwipeListViewListener myBaseSwipeListViewListener1 = new BaseSwipeListViewListener() {
    @Override
    public void onOpened(int position, boolean toRight) {
        onOpenedAdvanced(position, toRight, swipelistview1);
    } 
}

BaseSwipeListViewListener myBaseSwipeListViewListener2 = new BaseSwipeListViewListener() {
    @Override
    public void onOpened(int position, boolean toRight) {
        onOpenedAdvanced(position, toRight, swipelistview0);
    } 
}

public void onOpenedAdvanced(int position, boolean toRight, SwipeListView swipeListView){
    //Here you now have your calling swipelistview
}

swipelistview0.setSwipeListViewListener(myBaseSwipeListViewListener0);
swipelistview1.setSwipeListViewListener(myBaseSwipeListViewListener1);
swipelistview2.setSwipeListViewListener(myBaseSwipeListViewListener2);