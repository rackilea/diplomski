new Handler().post(new Runnable() {
    @Override
    public void run() {
        // Add the fragment on initial activity setup
    mainFragment = new MainFragment();
    getSupportFragmentManager()
    .beginTransaction()
    .add(android.R.id.content, mainFragment)
    .commit();
    }
});