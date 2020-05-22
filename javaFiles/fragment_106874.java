pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == WHATEVER) {
                    //do what you want

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });