private WebView mWebView;

    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.admin_console_activity);  

        mWebView = (WebView) findViewById(R.id.adminConsoleWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://gmumbai.co.in/admin");
}