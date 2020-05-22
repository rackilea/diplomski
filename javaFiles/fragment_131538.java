public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    requestWindowFeature(Window.FEATURE_NO_TITLE);

    setContentView(R.layout.activity_main);
    un = (EditText) findViewById(R.id.et_un);
    pw = (EditText) findViewById(R.id.et_pw);
    ok = (Button) findViewById(R.id.btn_login);

    textview = (TextView) findViewById(R.id.textView1);

    ok.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

             String username = un.getText().toString()));
             String password = pw.getText().toString()));
              new MyTask().execute(username, password);   // here I'm sending these two values to AsyncTask class
           }
    });

}

// here is the AsyncTask

    public class MyTask extends AsyncTask<String,Void,String> {

        @Override
    protected String doInBackground(String... params) {


       ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
                    postParameters.add(new BasicNameValuePair("UserID",
                            params[0]));    // params[0] contains the first value that you have passed and params[1] second value.
                    postParameters.add(new BasicNameValuePair("Password",
                            params[1]));

                    String response = null;
                    try {
                        response = SimpleHttpClient
                                .executeHttpPost("http://www.e-learning.com/wlc_loginok.asp",
                                        postParameters);
                         res = response.toString();

                        resp = res.replaceAll("\\s+", "");
                        System.out.println(res);

                         return res;
                    } catch (Exception e) {
                        e.printStackTrace();
                        errorMsg = e.getMessage();
                    }
   }  // end of doInBackground

      @Override
    protected Void onPostExecute(String res){
        super.onPostExecute(res);
        if(res.indexOf("<TITLE>LoginOk</TITLE>") != -1  ||(resp.indexOf("<TITLE>Login</TITLE>") != -1)) {                   
                    textview.setText("Incorrect User ID / Password");


                }
                else if(res.indexOf("Already") != -1){

                textview.setText("An account is already logged In");
                }
                else{
                textview.setText("Login Successful! ");
                }
                if (null != errorMsg && !errorMsg.isEmpty()) {
                    textview.setText(errorMsg);
                }
    }  // end of onPostExecute
}  // end of AsyncTask class