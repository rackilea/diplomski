@Override
protected void onDestroy()
{
    super.onDestroy();
    yourTimer.cancel();
}