public class FindEventsActivity extends Activity {

ProgressDialog pd;

// lots of other code up here
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.clickete);

    pd = new ProgressDialog(this);
    pd.setMessage("loading");

    findViewById(R.id.clickLayout).setOnClickListener(
            new OnClickListener() {

                @Override
                public void onClick(View v) {
                    new LongOperation().execute("");
                    pd.show();
                }
            });
}

private class LongOperation extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000); // Simulates your intensive work
                // Update your progress if you want
                this.publishProgress();
            } catch (InterruptedException e) {
                return "Failed";
            }
        }
        return "Executed";
    }

    @Override
    protected void onPostExecute(String result) {
        // Handle fail or success accordingly
        pd.dismiss();
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        // Update UI according to your progress
    }
}
}