@Override
   protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
     MediaPlayer dontcallme = MediaPlayer.create(this, R.raw.dontcallmedarling);
     dontcallme.start();
}