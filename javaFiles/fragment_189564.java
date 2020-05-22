@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.second);
    WebView wv= (WebView) findViewById(R.id.wv);
    Bundle extras= getIntent().getExtras();
    if(extras!=null)
    {
        wv.loadUrl(extras.getString("key"));
    }   
} 
 }