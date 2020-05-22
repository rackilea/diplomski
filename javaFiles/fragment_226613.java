public class ButtonActivity extends Activity {
    private static final String TIME_KEY = "time";
    private static final long PERIOD = 60*1000; // 60 seconds

    private SharedPreferences mPrefs;
    private Button mButton;
    private TextView mTimeView;

    private Runnable mDisplayTask = new Runnable() {
        @Override
        public void run() {
            // show the time elapsed since button press in milliseconds
            long elapsed = System.currentTimeMillis() - mPrefs.getLong(TIME_KEY, 0);
            mTimeView.setText(""+elapsed);
            // schedule next display update
            mTimeView.postDelayed(mDisplayTask, PERIOD);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPrefs = getPreferences(MODE_PRIVATE);
        // clear the button press time
        setPressTime(0);

        setContentView(R.layout.activity_demo);

        mButton = (Button)findViewById(R.id.button);
        mTimeView = (TextView)findViewById(R.id.time);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save the button press time
                setPressTime(System.currentTimeMillis());
                // start the display updates
                mDisplayTask.run();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // activity no longer visible; stop the updates
        mTimeView.removeCallbacks(mDisplayTask);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // activity is visible
        // if the button has been pressed, start the display updates
        if (mPrefs.getLong(TIME_KEY, 0) > 0) {
            mDisplayTask.run();
        }
    }

    private void setPressTime(long time) {
        // persist the button press time
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putLong(TIME_KEY, time);
        ed.commit();
    }
}