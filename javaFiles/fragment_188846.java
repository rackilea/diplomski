webView.setWebViewClient(new WebViewClient() {
    @Override
    public void onPageFinished(WebView view, String url) {
        // do your stuff here - This is optional
    }
    @Override
    public void onReceivedError( WebView view, int errorCode, String description, String failingUrl)  {
         webView.loadUrl("file:///android_asset/ErrorPage.html");
   }
});