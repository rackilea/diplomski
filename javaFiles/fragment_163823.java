@Override
public boolean isViewFromObject(View view, Object object) {
    return view.equals(object);
}

@Override
public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View)object);
}