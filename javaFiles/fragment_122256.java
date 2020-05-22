@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Fragment servicesFrag = bottomNavAdapter.getItem(mainViewPager.getCurrentItem());
    Fragment addressFrag = getSupportFragmentManager().findFragmentByTag("NewAddressFragmentTag");
    if (servicesFrag instanceof ServicesFragment) {
        ((ServicesFragment) servicesFrag).onActivityResult(requestCode, resultCode, data);
    }

    if (addressFrag instanceof NewAddressFragment) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}