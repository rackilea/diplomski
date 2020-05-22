@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState != null) {
      tabIndex = savedInstanceState.getInt("tabIndex", 0);
      // here, make sure your ViewPager's PagerAdapter is created and set it to this tab
    }
    // rest of your onCreate goes here
}