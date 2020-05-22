public void selectDrawerItem(int ItemId,IDrawerItem drawerItem) {
    // Create a new fragment and specify the fragment to show based on nav item clicked
    Fragment fragment = null;
    Class fragmentClass;
    switch(ItemId) {
        case 1:
            fragmentClass = PageFragment2.class;
            break;
        case 2:
            fragmentClass = PageFragment2.class;
            break;
         default:
            fragmentClass = PageFragment2.class;
    }
    try {
        fragment = (Fragment) fragmentClass.newInstance();
    } catch (Exception e) {
        e.printStackTrace();
    }
    // Insert the fragment by replacing any existing fragment
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    result.closeDrawer();
}