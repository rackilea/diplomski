private OnPageChangeListener mListener = new OnPageChangeListener() {

    @Override
    public void onPageSelected(int arg0) {
        // TODO Auto-generated method stub
        selectedIndex = arg0;

    }
    boolean callHappened;
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub
        if( mPageEnd && arg0 == selectedIndex && !callHappened)
        {
            Log.d(getClass().getName(), "Okay");
            mPageEnd = false;//To avoid multiple calls. 
            callHappened = true;
        }else
        {
            mPageEnd = false;
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub
        if(selectedIndex == adapter.getCount() - 1)
        {
            mPageEnd = true;
        }
    }
};
ViewPager.setOnPageChangeListener(mListener);