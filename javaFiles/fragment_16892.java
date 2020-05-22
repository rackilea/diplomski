private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.tab_11) {
                            mViewPager.setCurrentItem(0);
                        } else if (menuItem.getItemId() == R.id.tab_22) {
                            mViewPager.setCurrentItem(1);
                        } else if (menuItem.getItemId() == R.id.tab_33) {
                            mViewPager.setCurrentItem(3);
                        } else if (menuItem.getItemId() == R.id.setting_nav) {
                           Intent nextIntent = new Intent(getApplicationContext(), settingActivity.class);
                           startActivity(nextIntent);
                        }
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });