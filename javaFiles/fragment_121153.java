protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = (TextView) findViewById(R.id.your_text_view);

    new RequestTask().execute("http://www.url.com/ajaxrequest/?kategori=27"); 
}