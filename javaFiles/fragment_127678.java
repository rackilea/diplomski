mViewPager.setAdapter(adapter);
    mTabLayout.post(new Runnable() {
        @Override
        public void run() {
            mTabLayout.setupWithViewPager(mViewPager);
        }
    });