public   class ImageAdapter extends PagerAdapter {

    Context activity_context;
    public String mImages[] =  {("http://www.fashionlady.in/wp-content/uploads/2016/03/creative-punjabi-mehndi-design-2016.jpg"),
            ("https://lumiere-a.akamaihd.net/v1/images/uk_toystory_chi_woody_n_5b5a006f.png?region=0,0,300,300"),
            ("https://lumiere-a.akamaihd.net/v1/images/open-uri20150422-20810-10n7ovy_9b42e613.jpeg"),
            ("http://www.wetpaint.com/wp-content/uploads/2015/11/toy-story-20th-anniversary.jpg"),
            ("http://i.imgur.com/4IZMjx3.jpg")};
    public ImageAdapter(Context context)
    {
            activity_context=context;
    }
    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        ImageView imageView = new ImageView(activity_context);

        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        Picasso.with(activity_context).load(mImages[position]).placeholder(R.drawable.loading2).error(R.drawable.nointernet).into(imageView);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}