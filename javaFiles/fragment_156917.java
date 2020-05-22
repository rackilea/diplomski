setContentView(R.layout.main_activity);//then
   // set desired fragment for the first time
   FragmentManager fm = getSupportFragmentManager();
   FragmentTransaction ft = fm.beginTransaction();

    // The id specified here identifies which ViewGroup to
    // append the Fragment to.
    ft.add(R.id.fragment_placeHolder, new Fragment1());
    ft.commit();