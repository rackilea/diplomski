webview.setWebViewClient(new WebViewClient() {
    @Override
    public WebResourceResponse shouldInterceptRequest (final WebView view, String url) {
        if (you_want_to_intercept) {
            /*return custom WebresourceResponse here*/
        } else {
            /*call superclass*/
            return super.shouldInterceptRequest(view, url);
        }
    }
}