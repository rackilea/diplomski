public class SplashScreen extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread t = new Thread() {
            public void run() {
                try {
                    int time = 0;
                    while (time < 4000) {
                       sleep(100);
                       time += 100;
                    }
                }
                catch (InterruptedException e) {
                    // do nothing
                }
                finally {
                    finish();
                    Intent i = new Intent(SplashScreen.this, MainApplication.class);
                    startActivity(i);
                }
            }
        };
        t.start();

    }
}