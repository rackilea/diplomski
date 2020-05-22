mWebv.setWebViewClient(new WebViewClient(){
    ...
    @SuppressWarnings("deprecation")
    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
    {
    // do some stuff
    }

    @TargetApi(android.os.Build.VERSION_CODES.M)
    @Override
    public void onReceivedError(WebView inView, WebResourceRequest inReq,WebResourceError inError) 
    {
    // do some stuff
    onReceivedError(inView, inError.getErrorCode(), inError.getDescription().toString(), inReq.getUrl().toString());
    }
});