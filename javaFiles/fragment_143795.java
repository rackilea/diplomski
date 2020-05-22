viewPager.setOnPageChangeListener(new OnPageChangeListener() {

     int lastPosition;
     @Override
     public void onPageSelected(int position) {
            MyInterface fragment = (MyInterface)mPagerAdapter.instantiateItem(viewPager, lastPosition);
            if (fragment != null) {
                fragment.onFragmentExited();
            }
            /* If you want to notify the fragment being focused
            fragment = (MiniApp)mPagerAdapter.instantiateItem(viewPager, position);
            if (fragment != null) {
                fragment.onFragmentEntered();
            } */
            lastPosition = position;
     }                      
});