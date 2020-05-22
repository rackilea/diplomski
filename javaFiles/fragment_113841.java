@Override
protected void onPause() //Overrides onPause from Activity
{
    surfaceViews.peek().onPause();
    super.onPause();
}