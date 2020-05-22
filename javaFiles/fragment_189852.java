public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                // Load your data here
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

        };
        asyncTask.execute(null, null);
    }
}