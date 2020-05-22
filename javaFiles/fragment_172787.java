public class MainActivity extends Activity {
  CircleIndicator mPageIndicator;
@Override

public void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);

ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

ImagePagerAdapter adapter = new ImagePagerAdapter();

viewPager.setAdapter(adapter);
 mPageIndicator.setViewPager(mViewpager);

 }


private class ImagePagerAdapter extends PagerAdapter {

private int[] mImages = new int[] {
    R.drawable.chiang_mai,
    R.drawable.himeji,
    R.drawable.petronas_twin_tower,
    R.drawable.ulm
};

@Override
public int getCount() {
  return mImages.length;
}

@Override
public boolean isViewFromObject(View view, Object object) {
  return view == ((ImageView) object);
}

@Override
public Object instantiateItem(ViewGroup container, int position) {
  Context context = MainActivity.this;
  ImageView imageView = new ImageView(context);
  int padding = context.getResources().getDimensionPixelSize(
      R.dimen.padding_medium);
  imageView.setPadding(padding, padding, padding, padding);
  imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
  imageView.setImageResource(mImages[position]);
  ((ViewPager) container).addView(imageView, 0);
  return imageView;
}

@Override
public void destroyItem(ViewGroup container, int position, Object object) {
  ((ViewPager) container).removeView((ImageView) object);
}}