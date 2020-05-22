public class SplashScreen extends AppCompatActivity {

// Splash screen timer
private static int SPLASH_TIME_OUT = 2000;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    //showing splash screen for desired time
    new Handler().postDelayed(new Runnable() {

        /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         */

        @Override
        public void run() {
            // This method will be executed once the timer is over
            // Start your app main activity
            Intent i = new Intent(SplashScreen.this, Login.class);
            startActivity(i);

            // close this activity
            finish();
        }
    }, SPLASH_TIME_OUT);

}}