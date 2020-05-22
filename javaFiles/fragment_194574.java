public class test extends Activity {
    private TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //work...
    }

    public void buttonclick(View v){
        tv = new TextView(this);
        new Blap().execute(editText1.getText().toString(), editText2.getText().toString());
        setContentView(tv);
    }

    public class Blap extends AsyncTask<String, String, String> {
        private test parent;

        @Override
        protected String doInBackground(String... options) {
            this.auth(options[0], options[1]);
            String result = "my result";
            return result;
        }

        public auth(String login, String password){
            //process auth
        }

        @Override
        protected void onPostExecute(String _result) {
           tv.setText(_result);
        }
    }
}