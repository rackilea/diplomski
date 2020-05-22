static final int MSG_REDRAW = 1;

Handler handler = new Handler() {
    public void handleMessage(Message msg) {
        switch (msg.what) {
        case MSG_REDRAW:
            // This method invoked on UI thread - ok.
            draw.this.invalidate();
            sendEmptyMessage(MSG_REDRAW);
            break;

        default:
            super.handleMessage(msg);
            break;
        }
    }
}