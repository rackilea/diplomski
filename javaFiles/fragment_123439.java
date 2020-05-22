public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // call your long task from here
        doWork();
    }

    // write this method in your First Activity
    private void doWork()
    {

        new AsyncTask<Void, Void, String>()
        {

            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
            }

            @Override
            protected String doInBackground(Void... params) {

                // do your long task here

                // And return your result to the onPostExecute method.
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                // after finishing your task dismis your dialog.
                progressDialog.dismiss();

                // And go to your next Activity.

                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        }.execute();

    }
}