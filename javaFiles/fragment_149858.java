BroadcastReceiver br = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        setInitialData();
        mainAdapter.notifyDataSetChanged();
    }
};
IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
this.registerReceiver(br, filter);