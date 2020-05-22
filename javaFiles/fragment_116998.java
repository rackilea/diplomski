private class RecyclerViewDataObserver extends AdapterDataObserver {
@Override
public void onChanged() {
    assertNotInLayoutOrScroll(null);
    if (mAdapter.hasStableIds()) {
        // TODO Determine what actually changed.
        // This is more important to implement now since this callback will disable all
        // animations because we cannot rely on positions.
        mState.mStructureChanged = true;
        setDataSetChangedAfterLayout();
    } else {
        mState.mStructureChanged = true;
        setDataSetChangedAfterLayout();
    }
    if (!mAdapterHelper.hasPendingUpdates()) {
        requestLayout();
    }
}

@Override
public void onItemRangeChanged(int positionStart, int itemCount) {
    assertNotInLayoutOrScroll(null);
    if (mAdapterHelper.onItemRangeChanged(positionStart, itemCount)) {
        triggerUpdateProcessor();
    }
}
....