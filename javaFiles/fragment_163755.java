public class MainActivity extends Activity implements Calculator.calcCallback,  {

private TextView mScore;
private Button mRunButton;
private TextView mScoreText;
private ProgressBar mSpinner;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

mScore = (TextView) findViewById(R.id.score);
mRunButton = (Button) findViewById(R.id.runbutton);
mScoreText = (TextView) findViewById(R.id.scoreText);
mSpinner = (ProgressBar) findViewById(R.id.progress);

mSpinner.setVisibility(View.GONE);
View.OnClickListener listener = new View.OnClickListener(){
    @Override

    public void onClick(View v) {
        Calculator calculator = new Calculator(MainActivity.this);
        calculator.execute();
    }
};

mRunButton.setOnClickListener(listener);

}

@Override
public Void calcStarted() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSpinner.setVisibility(View.VISIBLE);
            }
        });
    }
    return null;
}
@Override
public Void calcDone() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSpinner.setVisibility(View.GONE);
            }
        });
    }
    return null;
}
}