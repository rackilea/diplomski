class YouActivity extends Activity { 

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.your_text_view);

        RequestTask requestTask = new RequestTask();
        requestTask.setTextView(textView);
        requestTask.execute("http://www.url.com/ajaxrequest/?kategori=27"); 
    } 

}