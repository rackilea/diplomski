BroadcastReceiver  mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (myText != null) {
                myText.setVisibility(View.VISIBLE);
            }
        }
    };