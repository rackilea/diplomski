public static class MyAdapter extends FragmentPagerAdapter {
    private int mPosition;
    public MyAdapter(FragmentManager fm, int position) {
        super(fm);
        mPosition = position;
    }
    ...
}