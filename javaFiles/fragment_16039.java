@Override
public boolean isViewFromObject(View view, Object o) {
return (view == (LinearLayout) o);
}

@Override
public void destroyItem(ViewGroup container, int position, Object   object) {
container.removeView((LinearLayout) object);
}