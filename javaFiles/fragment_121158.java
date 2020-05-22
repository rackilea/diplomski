class YouActivity extends Activity { 

    TextView textView;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
             String value = (String) msg.obj;
             textView.setText(value);
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.your_text_view);

        RequestTask requestTask = new RequestTask();
        requestTask.setHandler(handler);
        requestTask.execute("http://www.url.com/ajaxrequest/?kategori=27"); 
    } 

}