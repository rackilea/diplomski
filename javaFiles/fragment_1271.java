private MediaPlayer policeSound;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    policeSound = MediaPlayer.create(this, R.raw.police);
    Button policeSounds = (Button) this.findViewById(R.id.police);
    policeSounds.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (policeSound.isPlaying()) {
                        policeSound.stop();
                    } else {
                        policeSound.start();
                    }
                }
            }
    );
}