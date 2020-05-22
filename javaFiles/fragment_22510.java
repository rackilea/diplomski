import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static TextView txtCountDown;
    private static CountDownTimer countDownTimer = null;
        private static final long startTime = 120 * 1000;
        private static final long interval = 1 * 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCountDown = (TextView) findViewById(R.id.txtCountDown);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        if(txtCountDown!=null){
            txtCountDown.setText(String.valueOf(startTime / 1000));
        }
        countDownTimer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public class MyCountDownTimer extends CountDownTimer {

      public MyCountDownTimer(long startTime, long interval) {
          super(startTime, interval);
      }

      @Override
      public void onFinish() {
          if(txtCountDown!=null){
            txtCountDown.setText("Time's up!");
          }
      }

      @Override
      public void onTick(long millisUntilFinished) {
          if(txtCountDown!=null){
            txtCountDown.setText("" + millisUntilFinished / 1000);
          }
      }
   }
}