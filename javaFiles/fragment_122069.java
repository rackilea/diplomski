public class MainActivity extends AppCompatActivity {



    // ...



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        // ...From section above...

        // Find our drawer view

        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        // Setup drawer view

        setupDrawerContent(nvDrawer);

    }



    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override

                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        selectDrawerItem(menuItem);

                        return true;

                    }

                });

    }



    public void selectDrawerItem(MenuItem menuItem) {

        // Create a new fragment and specify the fragment to show based on nav item clicked

        Fragment fragment = null;

        Class fragmentClass;

        switch(menuItem.getItemId()) {

            case R.id.nav_first_fragment:

                fragmentClass = FirstFragment.class;

                break;

            case R.id.nav_second_fragment:

                fragmentClass = SecondFragment.class;

                break;

            case R.id.nav_third_fragment:

                fragmentClass = ThirdFragment.class;

                break;

            default:

                fragmentClass = FirstFragment.class;

        }



        try {

            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {

            e.printStackTrace();

        }



        // Insert the fragment by replacing any existing fragment

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();



        // Highlight the selected item has been done by NavigationView

        menuItem.setChecked(true);

        // Set action bar title

        setTitle(menuItem.getTitle());

        // Close the navigation drawer

        mDrawer.closeDrawers();

    }



    // ...

}