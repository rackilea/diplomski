@Override
protected void onRestart() {
    super.onRestart();

    Fragment listFragment = mSectionsPagerAdapter.getFragmentZero(); 

    listFragment.refreshListView();
}