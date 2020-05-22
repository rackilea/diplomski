navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Switch(item.getItemId()){  // the issue is here
                    case R.id.nav_logout:
                        SharedPrefManager.getInstance(this).logOut();
                        finish();
                        startActivity(new Intent(this, MainActivity.class));
                }