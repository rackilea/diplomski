BottomNavigationView mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    invalidateOptionsMenu();
                    switch (item.getItemId()) {
                        case R.id.click_to_use:
                           addHomeFragment(MainActivity.this);
                            mTitle.setText("Home");
                            item.setIcon(R.drawable.device);
                            break;
                        case R.id.history:
                           addNotifyFragment(MainActivity.this);
                            mTitle.setText("History");
                            item.setIcon(R.drawable.ios_icon);

                            break;
                        case R.id.settings:
                          addSettingFragment(MainActivity.this);
                            mTitle.setText("Settings");
                            break;
                    }

                    return true;

                }
            });