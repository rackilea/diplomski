private FragmentManager.OnBackStackChangedListener mOnBackStackChangedListener = new FragmentManager.OnBackStackChangedListener() {
        @Override
        public void onBackStackChanged() {
            boolean displayHomeAsUpEnabled = getSupportFragmentManager().getBackStackEntryCount() > 0;
            if(displayHomeAsUpEnabled){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }else{
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                mDrawerToggle.syncState();
            }
        }
    };