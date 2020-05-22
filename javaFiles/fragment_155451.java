WebView webView = (WebView) findViewById(R.id.webView);

webView.setWebViewClient(new WebViewClient() {
    public void onReceivedError(WebView view, int errorCode, String description,
                                String failingUrl) {
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        String password = "a123345";
       view.loadUrl("javascript:(function() { " +
               "document.getElementsByName('q')[0].value = '" + password + "'; " +
               "})()");
    }
});
webView.getSettings().setJavaScriptEnabled(true);

webView.loadUrl("https://google.com");