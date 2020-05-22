public class AndroidLauncher extends AndroidApplication {

Simulation simul;
ViewGroup layout;

SeekBar seekBar;

@Override
protected void onCreate (Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    simul = new Simulation();
    simul.setParent(this);


    setContentView(R.layout.main);
    layout = (ViewGroup) findViewById( R.id.panel );

    AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
    config.useWakelock = true;
    config.useAccelerometer = false;
    config.useCompass = false;
    layout.addView(initializeForView(simul, config));

    seekBar = (SeekBar) findViewById(R.id.seekBar);
    seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            System.out.println( progress );
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });

}

public void showSeekBar(){
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            seekBar.setVisibility( View.VISIBLE );
        }
    });

}


public void hideSeekBar(){
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            seekBar.setVisibility( View.GONE );
        }
    });

}