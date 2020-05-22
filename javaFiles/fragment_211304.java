new CountDownTimer(s, 1000) {
    public void onTick(long millisUntilFinished) {
        mSeconds.setText("" + millisUntilFinished / 1000);
    }

    public void onFinish() {
        finish();
    }
}.start();