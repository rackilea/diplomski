public class SplashScreen extends Activity {



            private static int SPLASH_TIME_OUT = 5000;  // Splash screen timer

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_splash);

                SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
final SharedPreferences.Editor ed = pref.edit()
                if(pref.getBoolean("activity_executed", false)){
                    //ed.putBoolean("activity_executed", true);
                    //ed.commit();

    Intent intent = new Intent(SplashScreen.this, VaultActivity.class);
                            startActivity(intent);
                            finish();
                } else {
                   new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Start main activity
                            Intent intent = new Intent(SplashScreen.this, VaultActivity.class);
                            startActivity(intent);

                    ed.putBoolean("activity_executed", true);
                    ed.commit();

                            finish();
                        }
                    }, SPLASH_TIME_OUT);

                }
            }
        }