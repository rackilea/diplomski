public class MainActivity extends AppCompatActivity implements Chronometer.OnChronometerTickListener {

    private String TAG = "MainActivity";
    Button start;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chron);
        start = findViewById(R.id.btn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.start();
            }
        });
        chronometer.start();
        chronometer.setOnChronometerTickListener(this);

    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        if (chronometer.getText().toString().equalsIgnoreCase("00:05")) {
            // Reset Chronometer
            chronometer.setOnChronometerTickListener(null);
            chronometer.stop();
            Log.d(TAG, "onChronometerTick: stop");

            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.setOnChronometerTickListener(this);


        }

    }
}