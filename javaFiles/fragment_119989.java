mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
    @Override
    public void onPageSelected(int position) {
        actionBar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int alphaCurrent = (int) (255 - (128*Math.abs(positionOffset)));
        int alphaNext = (int) (128 + (128*Math.abs(positionOffset)));
        if (positionOffset != 0) {
            switch(position) {
                case 0: 
                    tab0.setTheAlpha(alphaCurrent);
                    tab1.setTheAlpha(alphaNext);
                    break;
                case 1:
                    tab1.setTheAlpha(alphaCurrent);
                    tab2.setTheAlpha(alphaNext);
                    break;
                case 2:
                    tab2.setTheAlpha(alphaCurrent);
                    tab3.setTheAlpha(alphaNext);
                    break;
            }
        }
    }
});