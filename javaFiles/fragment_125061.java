private  WebView htmlWebView;
 String url = "https://yatln.com/appdev365/index.php";
   protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mainpage);


     htmlWebView = (WebView)findViewById(R.id.webView);
    if(url.contains("appdev365"))
    htmlWebView.setWebViewClient(new CustomWebViewClient());

    WebSettings webSetting = htmlWebView.getSettings();
    webSetting.setJavaScriptEnabled(true);
    webSetting.setDisplayZoomControls(true);
    htmlWebView.loadUrl(url);
}


private class CustomWebViewClient extends WebViewClient{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.equalsIgnoreCase("appdev365"))
            view.loadUrl(url);

        return true;
    }
}