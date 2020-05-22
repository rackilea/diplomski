private int tabIndex = 0 // NOTE: get this from your ViewPager's PagerAdapter
@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putInt("tabIndex", tabIndex)
}