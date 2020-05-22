// Message identifier
    private static final int MSG_SOME_MESSAGE = 1234;

    private Handler handler;

    ...

    handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == MSG_SOME_MESSAGE) {
                // do something
                // to repeat, just call sendEmptyMessageDelayed again
                return true;
            }
            return false;
        }
    });