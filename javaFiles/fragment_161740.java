wv_mem_rank.setWebViewClient(new WebViewClient() {
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.startWith("appname://com.appname"))
        {
            startActivity();
            finish();
        }
        view.loadUrl(url);
        return true;
    }
    public void onLoadResource (WebView view, String url) {
    }
    public void onPageFinished(WebView view, String url) {
    }
});