@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    if (intent.getAction() != null && intent.getAction().equals("SWITCH OFF")) {
        stopForeground(true);
        stopSelf();

        Menu menu = MainActivity.getThis().getMenu();
        MenuItem appBarSwitch = menu.findItem(R.id.app_bar_switch);
        appBarSwitch.setActionView(R.layout.switch_item);
        appBarSwitch.setChecked(false);
        Switch mSwitch = menu.findItem(R.id.app_bar_switch).getActionView().findViewById(R.id.action_switch);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Intent intent = new Intent(getApplicationContext(), BroadcastReceiverService.class);
                    startService(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), BroadcastReceiverService.class);
                    stopService(intent);
                }
            }
        });


    } else {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
    }
    return START_NOT_STICKY;

}