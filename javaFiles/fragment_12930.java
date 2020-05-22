@Override
public void onNavigationDrawerItemSelected(int position) {
    // update the main content by replacing fragments
    Fragment fragment = null;
    String title = "";

    switch (position) {
        case 0:
            fragment = new HomeFragment();
            title="Home";
            break;
        case 1:
            fragment = new AccountFragment();
            title="Accounts";
            break;
    }
    if (fragment == null) {
        fragment = new HomeFragment();
    }
    // update the main content by replacing fragments
    FragmentManager fragmentManager = getFragmentManager();
    fragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit();

    getSupportActionBar().setTitle(title);
}