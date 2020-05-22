public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         new DownloadTask().execute();
    }

    public void showInfo() {
    }

    class DownloadTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void data) {
            // we can call showInfo() activity because Asynctask hold an implicit reference to activity 
            showInfo();
        }
    }
}