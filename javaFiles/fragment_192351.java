if(savedInstanceState == null) {
    getSupportFragmentManager()
        .beginTransaction()
        .add(
            R.id.navigation_container,
            new NavigationFragment()
        )
        .commit();
}