@Override
public void onBackPressed()
{
  if (mDrawerLayout.isOpen())
    mDrawerLayout.close();
  else
    super.onBackPressed();
}