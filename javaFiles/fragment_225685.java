IntentFilter intentFilter = new IntentFilter();
 intentFilter.addAction("update_media_ui"); 
 updateMediaUiReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                // Get the data here and then set the text if 
                // the TextView is not null or save the data first 
                // and set it later if the TextView is null.
            }
        };
 registerReceiver(updateMediaUiReceiver, intentFilter);