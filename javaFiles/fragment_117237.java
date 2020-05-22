new CountDownTimer(endsIn * 1000, 1000) { 
public void onTick(long millisUntilFinished) { 
           timerTextView.setText(String.valueOf(millisUntilFinished/1000);
 } 
public void onFinish() {
} 
}.start();