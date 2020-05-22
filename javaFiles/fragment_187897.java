public class MainActivity extends AppCompatActivity {

MediaPlayer mediaPlayer;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //get the MediaPlayer object
    mediaPlayer = MediaPlayer.create(this,R.raw.facebook_tone);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            mediaPlayer.setVolume(100,100);

        }
    }, 2000);
}

@Override
protected void onPause() {
    super.onPause();
    //pause the music
    mediaPlayer.pause();
}

@Override
protected void onResume() {
    super.onResume();
    //validate if the mediaplayer is not null and not playing
    if(mediaPlayer != null && !mediaPlayer.isPlaying()){

        mediaPlayer.start();

    }
}