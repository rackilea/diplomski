@Override
protected void onStop()
{
    super.onStop();
    yourTimer.cancel();
}