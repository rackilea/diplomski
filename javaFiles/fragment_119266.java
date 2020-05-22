private void setViewPagerScroller() {
    try {
        Field scrollerField = ViewPager.class.getDeclaredField("mScroller");
        scrollerField.setAccessible(true);

        Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");
        interpolator.setAccessible(true);

        Scroller scroller = new Scroller(this, (android.view.animation.Interpolator) interpolator.get(null)){

            @Override
            public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                super.startScroll(startX, startY, dx, dy, duration * 7);
            }
        }

        scrollerField.set(viewPager, scroller);
    } catch (NoSuchFieldException error) {
        // Do nothing.
    } catch (IllegalAccessException error) {
        // Do nothing.
    }
}