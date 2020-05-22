public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
    @SuppressLint("DefaultLocale")
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(MainActivity.this, "broad", Toast.LENGTH_LONG).show();

        long millisUntilFinished = intent.getLongExtra("timer", 0);

        String counter = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));


        textView.setText(counter);
    }
};