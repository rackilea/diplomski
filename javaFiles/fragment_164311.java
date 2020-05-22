private class ImagePagerAdapter extends PagerAdapter {

    // this is your constructor
    public ImagePagerAdapter()
    {
        super();
        setOnPageChangeListener(mPageChangeListener);
    }