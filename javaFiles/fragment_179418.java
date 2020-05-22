protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    myintent = new Intent(this, MainActivity.class);

   new Handler().postDelayed(new Runnable(){
        @Override
        public void run() {
            startActivity(myintent);
            finish();
        }
    }, 1000);
}