mDrawerLayout = findViewById(R.id.drawer_layout);
    mDrawerLayout.postDelayed(new Runnable() {
        @Override
        public void run() {
            if (mDrawerLayout != null) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        }
    }, 200);