protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    super.setContentView(R.layout.collection);
    viewPager = (ViewPager) findViewById(R.id.viewPager);

    myAdapter = new MyAdapter();
    viewPager.setAdapter(myAdapter);

    ActionBar actionBar = getActionBar();
    if (actionBar != null) {
        actionBar.hide();
    }

    //Attach the page change listener inside the activity
    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

        // This method will be invoked when the current page is scrolled
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //This method will be invoked when a new page becomes selected
        @Override
        public void onPageSelected(int position) {
            //get position
            currentPage = position;

        }

        // Called when the scroll state changes:
        // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
        @Override
        public void onPageScrollStateChanged(int i) {

            //get state

        }
    });

}