Handler handler;

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    // Init field
    GameOverDialog = myInflater.inflate(R.layout.lose, null, false);
    // Set the handler
    handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == DEATH) {
                //play music
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = handler.obtainMessage();
                        msg.what = LOSE;
                        handler.sendMessage(msg);
                    }
                }, 1000);
            }
            if (msg.what == LOSE) {
                lose();
            }
            super.handleMessage(msg);
        }
    };
    ...
}