@Override
public int onStartCommand(Intent intent, int flags, int startId) {



    int milliseconds = 100* 1000;

    new CountDownTimer(milliseconds, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {

            Intent intent = new Intent("timer_tracking");
            intent.putExtra("timer", millisUntilFinished);
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

        }

        @Override
        public void onFinish() {

            stopSelf();
        }
    }.start();


    return START_STICKY;
}