protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
    mySound=MediaPlayer.create(splash.this, R.raw.crowd_sound);
    mySound.start();
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        public void run() {
            Intent splash_intent=new Intent(splash.this,MainLFC.class);
            startActivity(splash_intent);
            finish()
        }
     }, 3000);

}
@Override
protected void onPause() {
    super.onPause();
    mySound.release();
}