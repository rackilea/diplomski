LocalBroadcastManager.getInstance(this).registerReceiver(
            mMessageReceiver, new IntentFilter("sendResult"));

}


  private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
       validation();
    }
};