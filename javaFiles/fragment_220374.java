public class Activity() extends AppCompatActivity {

CustomArrayAdapter mArrayAdapter;
ViewPager mViewPager;

public void updateViewpager(){
    mArrayAdapter = new ArrayAdapter(context, itemList); // old items with new items
    mViewPager.setAdapter(mArrayAdapter);
    mArrayAdapter.notifyDataSetChanged();
}

...