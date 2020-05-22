public class MainActivity extends Activity {
       TextView t;  
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main); // activity main is the activity that you are currently working with
            t = (TextView)findViewById(R.id.text1); // this is the text view where you want the text response to appear.
            new TheTask().execute("http://demo.com/demo.php");
        }

       class TheTask extends AsyncTask<String,Void,String>
       {

        @Override
        protected String doInBackground(String... arg0) {
            String text =null;
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(arg0[0]);
                HttpResponse resp = httpclient.execute(httppost);
                HttpEntity ent = resp.getEntity();
                text = EntityUtils.toString(ent);
            }
            catch (Exception e) 
            { 
                 e.printStackTrace();
            }

            return text;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            t.setText(result);
        }

       }
}