@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    YoWeb = (WebView)findViewById(R.id.webview); // Move your declaration up here
    swipe = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
    swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            LoadWeb(YoWeb.getUrl());  // Pass in the current url to refresh
        }
    });

    LoadWeb("https://www.yoalfaaz.com");  // load the home page only once
}

public void LoadWeb(String url) // Pass in URL you want to load
{  

    WebSettings webSettings = YoWeb.getSettings();
    webSettings.setJavaScriptEnabled(true);
    YoWeb.loadUrl(url);  // Load the URL passed into the method
    swipe.setRefreshing(true);
    YoWeb.setWebViewClient(new WebViewClient() {

        //onPageFinished Method
        public void onPageFinished(WebView view, String url) {
            //Hide the SwipeRefreshLayout
            swipe.setRefreshing(false);
        }
    });
}