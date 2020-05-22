public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
   //Specify the list index that you want to check visibility
    int listItemIndex = 9;
    View listItem = getListView().getChildAt(listItemIndex);
    if (listItem  != null && listItem .getVisibility() == View.VISIBLE) {
     //The list item is visible
    }
}