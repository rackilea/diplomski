public String currentUrl = "";
webView.setWebViewClient(new WebViewClient() {

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        currentUrl = webView.getUrl();
    }

});