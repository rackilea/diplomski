protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
    mySound=MediaPlayer.create(splash.this, R.raw.crowd_sound);
    mySound.start();
    Thread kill_Thread= new Thread(){
        public void run(){
            try {
                sleep(3000);
                Intent splash_intent=new Intent(splash.this,MainLFC.class);
                startActivity(splash_intent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                finish();
            }
        }
    };
    kill_Thread.start();

}

@Override
protected void onPause() {
    super.onPause();
    mySound.release();
}