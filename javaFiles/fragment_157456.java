public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    //class variables
    private static final long COUNT_DOWN_TICKS = 100l;
    private static final long COUNT_DOWN_FINISH = 5000l;
    private long countdownElapsed = 0l;
    private Handler mCountDownHandler = new Handler();
    private Button next_button;
    private TextView timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // you must compensate for the actual layout for your activity
        setContentView(R.layout.activity_main);


        // you must compensate for the actual id of the TextView
        timer = findViewById(R.id.tvTimer);

        // you must compensate for the actual id of the Button
        next_button = findViewById(R.id.btnNext);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountDown();
            }
        });
    }

    private void startCountDown() {
        try {
            countdownElapsed = 0l;
            next_button.setEnabled(false);
            displayCountDown();
            mCountDownHandler.postDelayed(mCountDownRunnable, COUNT_DOWN_TICKS);
        }
        catch (Exception ex){
            Log.e(TAG, ex.getMessage());
        }
    }

    private Runnable mCountDownRunnable = new Runnable() {
        @Override
        public void run() {
            countdownElapsed = countdownElapsed + COUNT_DOWN_TICKS;

            if(countdownElapsed >= COUNT_DOWN_FINISH){
                releaseCountDownHandler();
                next_button.setEnabled(true);
            }
            else{
                mCountDownHandler.postDelayed(mCountDownRunnable, COUNT_DOWN_TICKS);
            }

            long secFull = countdownElapsed % 1000;
            if(secFull == 0){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayCountDown();
                    }
                });
            }
        }
    };

    private void releaseCountDownHandler() {
        try {
            if(mCountDownRunnable != null) {
                mCountDownHandler.removeCallbacks(mCountDownRunnable);
            }
        }
        catch (Exception ex){
            Log.e(TAG, ex.getMessage());
        }
    }


    private void displayCountDown(){
        long t = (COUNT_DOWN_FINISH - countdownElapsed)/1000;
        String myTime = String.valueOf(t);
        timer.setText(myTime); 
    }   

}