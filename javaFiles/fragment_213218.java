viewPager.setCurrentItem(1);
    viewPager.postDelayed(new Runnable() {
        @Override
        public void run() {
            viewPager.setCurrentItem(0);
        }
    },100);