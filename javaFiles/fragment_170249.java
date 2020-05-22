public class HomeActivity extends Activity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.home);
    }
    public void buttonPressed(View view) {
        new MyAsyncTask(this).execute(new String[] {"http://google.com/"});
    }
    private class MyAsyncTask extends AsyncTask<String, Void, String> {
        private Context context;
        public MyAsyncTask(Context context) {
            this.context = context;
        }
        @Override
        protected String doInBackground(String... params) {
            String page = getPage(params[0]);
                    //do any more work here that may take some time- like loading remote data from a web server, etc
            return page;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(context, "Data Retrieved: " + result, Toast.LENGTH_LONG).show();
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(context, "Getting Data!", Toast.LENGTH_LONG).show();
        }
    }
}