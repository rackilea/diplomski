package net.justanotherblog.swipeview;

      import java.util.Locale;

      import android.os.Bundle;
      import android.support.v4.app.Fragment;
      import android.support.v4.app.FragmentActivity;
      import android.support.v4.app.FragmentManager;
      import android.support.v4.app.FragmentPagerAdapter;
      import android.support.v4.app.NavUtils;
      import android.support.v4.view.ViewPager;
      import android.view.Gravity;
      import android.view.LayoutInflater;
      import android.view.Menu;
      import android.view.MenuItem;
      import android.view.View;
      import android.view.ViewGroup;
      import android.widget.TextView;

     public class MainActivity extends FragmentActivity {


    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
       List<Fragment> fragments = new Vector<Fragment>();

                fragments.add(Fragment.instantiate(this, FragmentOne.class.getName()));
                fragments.add(Fragment.instantiate(this, FragmentTwo.class.getName()));
                fragments.add(Fragment.instantiate(this, FragmentThree.class.getName()));
                fragments.add(Fragment.instantiate(this, FragmentFour.class.getName()));
                fragments.add(Fragment.instantiate(this, FragmentFive.class.getName()));
                fragments.add(Fragment.instantiate(this, FragmentSix.class.getName()));

mSectionsPagerAdapter=newSectionsPagerAdapter(super.getSupportFragmentManager(),fragments);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

//





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

                @Override
                public Fragment getItem(int position) {
                     int _pos = position % 6;
                     return fragments.get(_pos);

                }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
            case 0:
                return getString(R.string.title_section1).toUpperCase(l);
            case 1:
                return getString(R.string.title_section2).toUpperCase(l);
            case 2:
                return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply
     * displays dummy text.
     */
    public static class FragmentOne extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public DummySectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_dummy, container, false);
            TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
            dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

     }