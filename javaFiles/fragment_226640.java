if (savedInstanceState == null) {
    currentFragment = new MainFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction().
            replace(R.id.layout_for_fragments, currentFragment).commit();
}