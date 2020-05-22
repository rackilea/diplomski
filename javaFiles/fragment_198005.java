new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {

        String packageName = intent.getData().getEncodedSchemeSpecificPart();

    }
};
IntentFilter intentFilter = new IntentFilter();
intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
intentFilter.addDataScheme("package");
registerReceiver(mBroadcastReceiver, intentFilter);