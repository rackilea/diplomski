@Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, filter);

    }