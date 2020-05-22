private void timerDialog() {
    final CountDownTimer timer = new CountDownTimer(timerNum*1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            timerDialog.setMessage("Seconds Remaining: "+ (millisUntilFinished/1000));
        }

        @Override
        public void onFinish() {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(500);
            timerDialog.cancel();
        }
    };
    timerDialog = new AlertDialog.Builder(this).create();  
    timerDialog.setTitle("Timer");  
    timerDialog.setMessage("Seconds Remaining: "+timerNum*1000);
    timerDialog.setCancelable(false);
    timerDialog.setButton("Cancel", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface aboutDialog, int id) {
           timer.cancel();
        }
    });
    timerDialog.show();
    timer.start();
}