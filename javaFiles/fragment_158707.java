protected void onCreate (Bundle savedInstanceState) {

super.onCreate (savedInstanceState);

setContentView (R.layout.activity_screen1);


    new Handler().postDelayed(new Runnable() {

        @Override
        public void run() {
             Intent initial = new Intent (getApplicationContext (), scren2.class);

             startActivity (initial);

        }
    }, 1000);


}