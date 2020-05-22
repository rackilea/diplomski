// get the screen size
DisplayMetrics mDisplayMetrics = context.getResources().getDisplayMetrics();
// force view width to only be as wide as the screen
mSummaryView.setMaxWidth(mDisplayMetrics.widthPixels);

// could be a oneliner :P
mSummaryView.setMaxWidth((getContext().getResources().getDisplayMetrics()).widthPixels);