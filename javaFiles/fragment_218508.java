// try this
public class Time extends Activity {
    Chronometer mChronometer;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        mChronometer = new Chronometer(this);

        layout.addView(mChronometer);

        Button startButton = new Button(this);
        startButton.setText("Start");
        startButton.setOnClickListener(mStartListener);
        layout.addView(startButton);

        Button stopButton = new Button(this);
        stopButton.setText("Stop");
        stopButton.setOnClickListener(mStopListener);
        layout.addView(stopButton);

        Button resetButton = new Button(this);
        resetButton.setText("Reset");
        resetButton.setOnClickListener(mResetListener);
        layout.addView(resetButton);

        setContentView(layout);
    }

    private void showElapsedTime() {
        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
        Toast.makeText(MyActivity.this, "Elapsed milliseconds: " + elapsedMillis,
                Toast.LENGTH_SHORT).show();
    }

    View.OnClickListener mStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            int stoppedMilliseconds = 0;

            String chronoText = mChronometer.getText().toString();
            String array[] = chronoText.split(":");
            if (array.length == 2) {
                stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000
                        + Integer.parseInt(array[1]) * 1000;
            } else if (array.length == 3) {
                stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000
                        + Integer.parseInt(array[1]) * 60 * 1000
                        + Integer.parseInt(array[2]) * 1000;
            }

            mChronometer.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);
            mChronometer.start();
        }
    };

    View.OnClickListener mStopListener = new View.OnClickListener() {
        public void onClick(View v) {
            mChronometer.stop();
        }
    };

    View.OnClickListener mResetListener = new View.OnClickListener() {
        public void onClick(View v) {
            mChronometer.setBase(SystemClock.elapsedRealtime());
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        prepareSharedData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mChronometer.setText(sharedPreferences.getString("time", "00:00"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        prepareSharedData();
    }

    public void prepareSharedData(){
        String chronoText = mChronometer.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("time", chronoText);
        editor.commit();
    }
}