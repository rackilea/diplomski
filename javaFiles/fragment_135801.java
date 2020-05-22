public class MnnnnnActivity extends AppCompatActivity {


private VerticalViewPager vp;
private MPagerAdapter mPagerAdapter;
private int lastPage = 0;
private List<String> songs = new ArrayList<String>();

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout5);

    vp = (VerticalViewPager) findViewById(R.id.vp);

    for(int i = 0 ; i<10  ; i++){
        songs.add(i , "song " + i);
    }

    mPagerAdapter = new MPagerAdapter(getApplicationContext(), songs);
    vp.setAdapter(mPagerAdapter);
    vp.setOffscreenPageLimit(1);

    vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(lastPage > position){ //left

            }else{ // right

            }
            lastPage = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });

}

}