private class Class2Receiver extends BroadcastReceiver 
{
        @Override
        public void onReceive(Context context, Intent intent) 
{
            Class2.this.class2Refresh();
         }
    }