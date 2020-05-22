public class ViewPagerActivity extends AppCompatActivity {

String imageList = null;
String[] propertyImageArray = {};


@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_view_pager);
//get imageList url from Intent
imageList = getIntent().getStringExtra("imageList");
propertyImageArray = imageList.split(",");
ViewPager viewPager = findViewById(R.id.view_pager);
viewPager.setAdapter(new SamplePagerAdapter());
}

class SamplePagerAdapter extends PagerAdapter {

@Override
public int getCount() {
    return propertyImageArray.length;
}

@Override
public View instantiateItem(ViewGroup container, int position) {
    //Must call notifyDataSetChanged before adding imageList to View
    //otherwise it'll crash