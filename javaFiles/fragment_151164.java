@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    TimerTask splash = new TimerTask(){
        public void run() {
            onDestroy();
            startActivity(new Intent(Splash.this, MainActivity.class));
        }
    };

    Timer splashScreenTimer = new Timer();
    // Timer set to 4.5 seconds
    splashScreenTimer.schedule(splash, 5000);
}