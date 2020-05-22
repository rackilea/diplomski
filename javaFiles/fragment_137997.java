// Loading the fragment with a tag:
FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
ft.replace(R.id.content, new HomeFragment(), "HOME_FRAGMENT");
ft.commit();

// then later check if the fragment is there:
HomeFragment fHome = (HomeFragment) getSupportFragmentManager().findFragmentByTag("HOME_FRAGMENT");

if (fHome != null && fHome.isVisible())
{
    // my fragment is inflated and visible
}