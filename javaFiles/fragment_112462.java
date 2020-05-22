public class MainActivity extends AppCompatActivity {
    private CustomPagerAdapter customPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());

        // 2 is enough for us; increase if you have more tabs!
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(customPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed()
    {
        if(!BackStackFragment.handleBackPressed(getSupportFragmentManager())){
            super.onBackPressed();
        }
    }

    public void openNextFragment() {
        HostFragment hostFragment = (HostFragment) customPagerAdapter.getItem(viewPager.getCurrentItem());

        // your logic to change the fragments...
    }
}