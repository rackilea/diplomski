protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);

   VideoView videoView = (VideoView) findViewById(R.id.video);
   videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
}