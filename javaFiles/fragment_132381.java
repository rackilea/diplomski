@Override
public Bundle saveHierarchyState() {
    Bundle outState = new Bundle();
    if (mContentParent == null) {
        return outState;
    }
    SparseArray<Parcelable> states = new SparseArray<Parcelable>();
    mContentParent.saveHierarchyState(states);
    outState.putSparseParcelableArray(VIEWS_TAG, states);
    // save the focused view id
    View focusedView = mContentParent.findFocus();
    if (focusedView != null) {
        if (focusedView.getId() != View.NO_ID) {
            outState.putInt(FOCUSED_ID_TAG, focusedView.getId());
        } else {
            if (false) {
                Log.d(TAG, "couldn't save which view has focus because the focused view "
                        + focusedView + " has no id.");
            }
        }
    }
    // save the panels
    SparseArray<Parcelable> panelStates = new SparseArray<Parcelable>();
    savePanelState(panelStates);
    if (panelStates.size() > 0) {
        outState.putSparseParcelableArray(PANELS_TAG, panelStates);
    }
    if (mActionBar != null) {
        outState.putBoolean(ACTION_BAR_TAG, mActionBar.isOverflowMenuShowing());
    }
    return outState;
}