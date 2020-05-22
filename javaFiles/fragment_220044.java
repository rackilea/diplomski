public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadTask(this).execute();
    }

    public void showInfo() {
    }
}

class DownloadTask extends AsyncTask<Void, Void, Void> {
    WeakReference<MainActivity> mainActivityWeakReference;

    public DownloadTask(MainActivity activity) {
        mainActivityWeakReference = new WeakReference<MainActivity>(activity);
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Void data) {
        if (mainActivityWeakReference.get() != null) {
            mainActivityWeakReference.get().showInfo();
        }
    }
}