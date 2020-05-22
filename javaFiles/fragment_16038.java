@Override
public boolean isViewFromObject(View view, Object o) {
return (view == (RelativeLayout) o);
}

@Override
public void destroyItem(ViewGroup container, int position, Object   object) {
container.removeView((RelativeLayout) object);
}