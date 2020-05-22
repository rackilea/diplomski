public void onNavigationDrawerItemSelected(int position) {
    // update the main content by replacing fragments
    Fragment fragment;
    FragmentManager fragmentManager = getFragmentManager(); // For AppCompat use getSupportFragmentManager
    switch(position) {
        default:
        case 0:
            fragment = new MyFragment1();
            break;
        case 1:
            fragment = new MyFragment2();
            break;
    }
    fragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit();
}