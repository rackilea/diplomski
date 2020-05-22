act2InitReceiver= new BroadcastReceiver()
    {

        @Override
        public void onReceive(Context context, Intent intent)
        {
            // do your listener event stuff
        }
    };
LocalBroadcastManager.getInstance(this).registerReceiver(act2InitReceiver, new IntentFilter("activity-2-initialized"));