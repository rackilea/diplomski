public static void startTimer(final TextView TVtime) {
    duration = 10;

    final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TVtime.setText((String) msg.obj);
        }
    };

    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
            Message msg = new Message();
            msg.obj = setDuration();
            handler.sendMessage(msg);
        }
    }, 1000, 1000);
}