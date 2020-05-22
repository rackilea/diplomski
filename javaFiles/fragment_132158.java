private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(!wifiManager.isWifiEnabled());
        }
    };

@Override
protected void onResume() {
    super.onResume();
    registerReceiver(broadcastReceiver, new IntentFilter(STR_RECEIVER));
}

@Override
protected void onPause() {
    super.onPause();
    unregisterReceiver(broadcastReceiver);
}