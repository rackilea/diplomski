webView.setWebViewClient(new WebViewClient(){
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

        // you can now query the DOM.
        webView.loadUrl("javascript:var a = document.getElementById('imgCaptcha').src;");
    }
});