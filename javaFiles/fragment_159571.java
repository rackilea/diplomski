protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);

    MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.p);
    mediaPlayer.start();
 }