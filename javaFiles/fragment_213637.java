// Get and set the values for the OffsetPadding for the RecyclerView to int.
    int itemOffsetPaddingSide = (int) getResources().getDimension(R.dimen.item_offset);
    int actionBarSize = (int) getResources().getDimension(R.dimen.actionbarSizeWithExtraPadding);
    int itemOffsetPaddingTop = actionBarSize + statusBarHeight;
    // Set all the OffsetPadding values to the RecyclerView programmatically, so that
    // all the UI elements are padding properly, taking into account the devices screen
    // density/size/resolution!
    mRecyclerView.setPadding(itemOffsetPaddingSide, itemOffsetPaddingTop, itemOffsetPaddingSide, itemOffsetPaddingSide);