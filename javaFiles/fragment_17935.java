public void onCreate(Bundle savedInstanceState){
   ...
    LocalBroadcastManager.getInstance(this).registerReceiver(mLocalBroadcastReceiver, new IntentFilter("broadcastName"));
}

private BroadcastReceiver mLocalBroadcastReceiver = new BroadcastReceiver() {

    @Override
    public void onReceive(Context context, Intent intent) {

        //MODIFY YOUR IMAGE BUTTON HERE

    }
};