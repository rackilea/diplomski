public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.somelayout);

    String url = "http://bigdaddyapp.com";

    webview = (WebView) findViewById(R.id.myWebView);
    //next line explained below
    webview.setWebViewClient(new MyWebViewClient(this));
    webview.getSettings().setJavaScriptEnabled(true);
    webview.loadUrl(url);
}