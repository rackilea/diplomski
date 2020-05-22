@Override
public void onDrawerSlide(View drawerView, float slideOffset)
{
     super.onDrawerSlide(drawerView, slideOffset);
     mDrawerLayout.bringChildToFront(drawerView);
     mDrawerLayout.requestLayout();
     mDrawerLayout.setScrimColor(Color.TRANSPARENT);

}