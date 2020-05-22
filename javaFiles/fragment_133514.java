BroadcastReceiver br = new BroadcastReceiver() {
    @Override
    onReceive(Context context, Intent intent) {
        Bundle b = intent.getExtras();
        if (b.hasExtra(DIRECTORY_EXTRA)) {
            textField.setText(b.getString(DIRECTORY_EXTRA));
        }
    }
}