private TextView noItems(String text) {
    TextView emptyView = new TextView(getActivity());
    //Make sure you import android.widget.LinearLayout.LayoutParams;
    emptyView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT));
    //Instead of passing resource id here I passed resolved color 
    //That is, getResources().getColor((R.color.gray_dark))
    emptyView.setTextColor(getResources().getColor(R.color.gray_dark));
    emptyView.setText(text);
    emptyView.setTextSize(12);
    emptyView.setVisibility(View.GONE);
    emptyView.setGravity(Gravity.CENTER_VERTICAL
            | Gravity.CENTER_HORIZONTAL);

    //Add the view to the list view. This might be what you are missing
    ((ViewGroup) getListView().getParent()).addView(emptyView);

    return emptyView;
}