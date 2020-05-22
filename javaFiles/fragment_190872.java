public static void setListViewHeightBasedOnChildren(final ListView listView) {
listView.post(new Runnable() {
    @Override
    public void run() {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int listWidth = listView.getMeasuredWidth();
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(
                    View.MeasureSpec.makeMeasureSpec(listWidth, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));


            totalHeight += listItem.getMeasuredHeight();
            Log.d("listItemHeight " + listItem.getMeasuredHeight(), "********");
        }

        Log.d("totalHeight " + totalHeight, "********");

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = (totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1)));
        listView.setLayoutParams(params);
        listView.requestLayout();

    }
});
}