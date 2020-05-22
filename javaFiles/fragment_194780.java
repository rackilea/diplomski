mWebView.setWebViewClient(new com.c.MyAppWebViewClient() { 

    @Override 
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        findViewById(R.id.progressBar1).setVisibility(View.VISIBLE);
    } 

    @Override 
    public void onPageFinished(WebView view, String url) {
        findViewById(R.id.progressBar1).setVisibility(View.GONE);

        findViewById(R.id.activity_main_webview).setVisibility(View.VISIBLE);
    } 
});