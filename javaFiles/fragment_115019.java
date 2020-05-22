@Override
public void onStart() {
    super.onStart();
    getListView().setEmptyView(
            noItems(getResources().getString(R.string.widget_empty)));
}