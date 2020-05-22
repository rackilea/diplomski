webview.setWebViewClient(new WebViewClient(){

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler,SslError error) {
        handler.proceed();
    }


});