PhotoView photoView = new PhotoView(ViewPagerActivity.this);
    GlideApp.with(ViewPagerActivity.this)
            .load(propertyImageArray[position])
            .fitCenter()
            .into(photoView);

    // Now just add PhotoView to ViewPager and return it
    container.addView(photoView,
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    return photoView;


}

@Override
public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
}

@Override
public boolean isViewFromObject(View view, Object object) {
    return view == object;
}