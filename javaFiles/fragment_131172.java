public class YourClass {

public CountDownTimer timer = null;

...
timer = new CountDownTimer(11000, 1000) {

         public void onTick(long millisUntilFinished) {
            clock.setText("Seconds Remaining: " + millisUntilFinished / 1000);
            secsrem = (int) millisUntilFinished / 1000;
         }

         public void onFinish() {
             //...}
      }

timer.start();
...