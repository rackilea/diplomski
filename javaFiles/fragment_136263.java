@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.textview);

    mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
    mViewPager = (ViewPager) findViewById(R.id.container);
    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // Here you get a new position.
                textView.setText("you're in tab" + String.valueOf(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    setupViewPager(mViewPager);
}