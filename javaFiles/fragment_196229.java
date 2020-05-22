public class MainActivity extends Activity {
/** Called when the activity is first created. */
long timeWhenStopped = 0;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final Button butStart = (Button) findViewById(R.id.button1);
    final Button butStop = (Button) findViewById(R.id.button2);
    final Button butReset = (Button) findViewById(R.id.button3);

    final Chronometer Mchronometer = (Chronometer) findViewById(R.id.chronometer1);

    butStart.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {                  Mchronometer.setBase(SystemClock.elapsedRealtime()
                            +timeWhenStopped);
            Mchronometer.start();
        }
    });

    butStop.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            timeWhenStopped = Mchronometer.getBase() - SystemClock.elapsedRealtime();
            Mchronometer.stop();
        }
    });

    butReset.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Mchronometer.setBase(SystemClock.elapsedRealtime());
            Mchronometer.stop();
            timeWhenStopped = 0;
        }
    });
    }