public Fragment getVisibleFragment() {
    android.support.v4.app.FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
    List<Fragment> fragments = fragmentManager.getFragments();
    if (fragments != null) {
        for (Fragment fragment : fragments) {
            if (fragment != null && fragment.isVisible())
                return fragment;
        }
    }
    return null;
}