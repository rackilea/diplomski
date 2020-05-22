public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener { 
    // Your Activity
        @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment fragment = null;

        switch(menuItem.getItemId()) {
            case R.id.drawer_home:
                fragment = new YourFragment();
                break;
            case R.id.drawer_content:
                fragment = new AnotherFragment();
                break;
            case R.id.drawer_about:
                fragment = new AboutFragment();
                break;
            case R.id.drawer_exit:
                // TODO - Prompt to exit.
                finish();
                break;
        }

        if (fragment == null) {
            fragment = new YourFragment();
        }

        drawerLayout.closeDrawers();

        FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();

        return true;
    }
}