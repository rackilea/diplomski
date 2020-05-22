public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    /* code for Splashscreen that appears for 3s when app start*/
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(MainActivity.this, UserManual.class);
            startActivity(i);
            finish();
        }
    }, 3000);

  }

}