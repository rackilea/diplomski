TextView _tv = (TextView) findViewById( R.id.textView1 );
new CountDownTimer(30000, 1000) { // adjust the milli seconds here

    public void onTick(long millisUntilFinished) {
    _tv.setText(""+String.format("%d min, %d sec", 
                    TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - 
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
    }

    public void onFinish() {
       _tv.setText("done!");
    }
 }.start();