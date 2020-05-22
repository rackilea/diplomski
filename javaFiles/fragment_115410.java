class UpdateHandler extends Handler {
    private static final int MSG_UPDATE = 1;
    private static final long UPDATE_INTERVAL = 1000; // msec

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case MSG_UPDATE:
                // do stuff...
                scheduleNextUpdate();
                break;
        }
    }

    void scheduleNextUpdate() {
        sendEmptyMessageDelayed(MSG_UPDATE, UPDATE_INTERVAL);
    }

}