private class MyWebChromeClient extends WebChromeClient {

    private WebView mWebView;
    public MyWebChromeClient(WebView webView)
    {
        mWebView = webView;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        if (newProgress == 100) {
            mWebView.loadUrl("javascript:callFromActivity('some msg')");
        }
    }
}