class TestReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
       if (intent.getAction().equals(AppConstants.FILTER_TESTING))
       {
          // code here
       }
    }
 }