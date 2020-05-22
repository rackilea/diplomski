viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {       

    }

    @Override
    public void onPageSelected(int position) {
         if (position == 0) { // Condition may vary according to your needs...
             troy.setVisibility(View.GONE);
         } else {
             troy.setVisibility(View.VISIBLE);
         }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
});