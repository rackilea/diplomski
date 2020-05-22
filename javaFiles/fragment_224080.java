bottomNavigationView .OnNavigationItemSelectedListener . 
   mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_shop:
                toolbar.setTitle("Shop");
                return true;
            case R.id.navigation_gifts:
                toolbar.setTitle("My Gifts");
                return true;
            case R.id.navigation_cart:
                toolbar.setTitle("Cart");
                return true;
            case R.id.navigation_profile:
                toolbar.setTitle("Profile");
                return true;
        }
        return false;
    }
};