@Override
public boolean isViewFromObject(View view, Object object) {
    return false;
}

@Override
public void destroyItem( ViewGroup container, int position,  Object object) {
    ViewPager vp = (ViewPager) container;
    View view = (View) object;
    vp.removeView((View)view);

}