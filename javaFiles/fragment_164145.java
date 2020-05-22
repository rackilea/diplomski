ViewPager pager;
FragmentStatePagerAdapter adapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_continue_story);
    new GetStory().execute();

    pager = (ViewPager) findViewById(R.id.pager);
    adapter = new MyPagerAdapter(getSupportFragmentManager())
    pager.setAdapter(adapter);
}