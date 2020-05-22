public void destroyItem (ViewGroup container, int position, Object object)
{
    ((ImageView)object).setImageResource(0);
    BitmapDrawable bmd = (BitmapDrawable) ((ImageView) object).getDrawable();
    if (bmd != null) bmd.getBitmap().recycle();
    View view = (View)object;
    ((ViewPager) container).removeView(view);
    view = null;
}