private class TestAdapter extends PagerAdapter {

    private int mCurrentPosition = -1;

    @Override
    public int getCount() {
        return pageAmount;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        int layoutThingy;

        switch(position) {
            case 0:
                layoutThingy = R.layout.fragment_generalsettingsinputdialog1;
                break;
            case 1:
                layoutThingy = R.layout.fragment_generalsettingsinputdialog2;
                break;
            case 2:
                layoutThingy = R.layout.fragment_generalsettingsinputdialog3;
                break;
            default:
                layoutThingy = R.layout.fragment_viewpagererror;
        }

        View view = inflater.inflate(layoutThingy, null);
        container.addView(view);
        view.requestFocus();
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        if (position != mCurrentPosition) {
            View view = (View) object;
            CustomPager pager = (CustomPager) container;
            if (view != null) {
                mCurrentPosition = position;
                pager.measureCurrentView(view);
            }
        }
    }
}