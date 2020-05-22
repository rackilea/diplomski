webviewB.setWebViewClient(new WebViewClient(){
    @Override
    public void onPageFinished(WebView view, String url{                               
        webviewA.setVisibility(View.GONE);
        webviewB.setVisibility(View.VISIBLE);
    }
});