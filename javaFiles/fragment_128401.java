@Override
public void onClick(View v) {

    // move it in here
    int time = Integer.parseInt(intervalTxt.getText().toString()) * 1000;
    new CountDownTimer(time, 1000) {

     public void onTick(final long millisUntilFinished) {