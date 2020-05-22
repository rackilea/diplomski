@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    //Clear the Activity's bundle of the subsidiary fragments' bundles.
    outState.clear();
}