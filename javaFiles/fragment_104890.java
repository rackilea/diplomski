/**
 * read all adapter views and calculate total length
 *
 * @param listView
 */
public static void setListViewHeightBasedOnChildren(ListView listView) {
    ListAdapter listAdapter = listView.getAdapter();
    if (listAdapter == null) {
        return;
    }

    int totalHeight = 0;
    int desiredWidth = MeasureSpec.makeMeasureSpec(listView.getWidth(), MeasureSpec.AT_MOST);
    for (int i = 0; i < listAdapter.getCount(); i++) {
        View listItem = listAdapter.getView(i, null, listView);
        listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
        totalHeight += listItem.getMeasuredHeight();
    }

    setListViewHeight(listView, totalHeight);
}

/**
 * set listview height
 *
 * @param listView
 * @param height
 */
public static void setListViewHeight(ListView listView, int height) {
    ViewGroup.LayoutParams params = listView.getLayoutParams();
    params.height = height + (listView.getDividerHeight() * (listView.getAdapter().getCount() - 1));
    listView.setLayoutParams(params);
    listView.requestLayout();
}