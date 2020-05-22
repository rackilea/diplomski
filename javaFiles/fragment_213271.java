private final BroadcastReceiver mHandleMessageReceiver =
        new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        mTextView.setText("Registration state is: " + intent.getExtras().getString("REGISTRATION_STATE");
    }
};