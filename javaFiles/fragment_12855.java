public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //Loop to get tids of all completely visible List View's item scrolled on screen
        for (int listItemIndex = 0; listItemIndex<=getListView().getLastVisiblePosition()- getListView().getFirstVisiblePosition(); listItemIndex++) {
        //Specify the list index that you want to check visibility
        View listItem = getListView().getChildAt(listItemIndex);
        if (listItem  != null && listItem .getVisibility() == View.VISIBLE) {
            //The list item is visible
        }
    }
}