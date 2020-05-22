@Override
protected void onPause() {
    super.onPause();
    bundle = new Bundle();
    Parcelable parcelable = recyclerView.getLayoutManager().onSaveInstanceState();
    bundle.putParcelable(KEY_RECYCLER_STATE, parcelable);
}

@Override
protected void onResume()
{
    super.onResume();

    // restore RecyclerView state
    if (bundle != null) {
        Parcelable parcelable = bundle.getParcelable(KEY_RECYCLER_STATE);
        recyclerView.getLayoutManager().onRestoreInstanceState(parcelable);
    }
}