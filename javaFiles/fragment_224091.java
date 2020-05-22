// Intercepting touch events
mapFragment.setListener(new TouchableGoogleMapFragment.OnTouchListener() {
    @Override
    public void onTouch() {
        mScrollView.requestDisallowInterceptTouchEvent(true);
    }
});