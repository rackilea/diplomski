private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //int for List, String for Dictionary
            String item_id_or_name = intent.getExtra("ITEM_ID_OR_NAME");
            int status_for_item = intent.getExtra("ITEM_STATUS");
            //find this item in you List or Dictionary
            //and set new Status for this item
            yourAdapter.notifyDataSetChanged();
        }
};
@Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(YourActivity.this).registerReceiver(receiver, 
                                          new IntentFilter("FILTER_NAME"));
    }
@Override
    public void onPause() {
        LocalBroadcastManager.getInstance(YourActivity.this).unregisterReceiver(receiver);
        super.onPause();
    }