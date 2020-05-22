rigthMenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
                mDrawerLayout.closeDrawer(GravityCompat.END);
            }
            else {
                mDrawerLayout.openDrawer(GravityCompat.END);
            }
        }
    });