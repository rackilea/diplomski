Fragment wel = new WelcomeFragment();  // correct naming schema 
wel.setArguments(getIntent().getExtras());
getSupportFragmentManager()
    .beginTransaction()
    .add(R.id.fragment_container, wel)
    .commit();