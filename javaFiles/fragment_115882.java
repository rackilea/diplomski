public class MainActivity extends AppCompatActivity {


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final MediaPlayer mediaPlayer = new MediaPlayer();

    Button john_cena_button = (Button) findViewById(R.id.john_cena_button);
    john_cena_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            stopAndPlay(R.raw.john_cena, mediaPlayer);
        }
    });

    Button ha_gay_button = (Button) findViewById(R.id.ha_gay_button);
    ha_gay_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            stopAndPlay(R.raw.ha_gay, mediaPlayer);
        }
    });
}

// This resets the mediaPlayer and starts the given audio
private void stopAndPlay(int rawId, MediaPlayer mediaPlayer) {
    mediaPlayer.reset();
    AssetFileDescriptor afd = this.getResources().openRawResourceFd(rawId);
    try {
        mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        mediaPlayer.prepare();
    } catch (IOException e) {
        e.printStackTrace();
    }
    mediaPlayer.start();
}

}