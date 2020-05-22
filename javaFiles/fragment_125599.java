The code below works perfectly for me.  

 public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private ProgressBar progressBar;
private CountDownTimer countDownTimer;
private Button stopTimerButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    progressBar = (ProgressBar)findViewById(R.id.progressBar);
    stopTimerButton = (Button)findViewById(R.id.button);
    stopTimerButton.setOnClickListener(this);
    int timeoutSeconds = 5000;
    progressBar.setMax(timeoutSeconds);
    countDownTimer = new CountDownTimer(timeoutSeconds,100) {
        @Override
        public void onTick(long millisUntilFinished) {
            int timeUntilFinished = (int) millisUntilFinished;
            progressBar.setProgress(timeUntilFinished);
        }

        @Override
        public void onFinish() {

        }
    };
    countDownTimer.start();

}

@Override
public void onClick(View view) {
    if(view == stopTimerButton){
        countDownTimer.cancel();
    }
}
}