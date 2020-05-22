public class MyActivity extends Activity implements ActionBar.TabListener {

SectionsPagerAdapter mSectionsPagerAdapter;
ViewPager mViewPager;
double mcount;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
    Button start;
    final TextView stopwatch_num;
    mcount = 0.0;
    start = (Button)findViewById(R.id.start_button);
    stopwatch_num = (TextView)findViewById(R.id.timer_num);
    start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mcount = mcount + .01;
            stopwatch_num.setText(""+mcount);
        }


    });