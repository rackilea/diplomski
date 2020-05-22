navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Switch(item.getItemId()){  // the issue is here
                        case R.id.nav_logout:
                            SharedPrefManager.getInstance(mContext).logOut();
                            finish();
                            startActivity(new Intent(mContext, MainActivity.class));
                    }