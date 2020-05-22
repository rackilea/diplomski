public class player extends Activity {
    Button stop;
    static MediaPlayer audio;

    @Override
    public void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_player);

        stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stop();
            }
        });

        if(audio == null) {
            audio = MediaPlayer.create(getBaseContext(), R.raw.myaudio);
            audio.start();
        } else {
            if(audio.isPlaying()) {
                audio.stop();
                audio = MediaPlayer.create(getBaseContext(), R.raw.myaudio);
                audio.start();
            } else {
                audio = MediaPlayer.create(getBaseContext(), R.raw.myaudio);
                audio.start();
            }
        }
    }

}