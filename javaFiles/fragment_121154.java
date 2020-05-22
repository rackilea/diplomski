class YouActivity extends Activity { 

    TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.your_text_view);

        new RequestTask().execute("http://www.url.com/ajaxrequest/?kategori=27"); 
    }

    class RequestTask extends AsyncTask<String, String, String> {
        ...
        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
        }
    } 

}