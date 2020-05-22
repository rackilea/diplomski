private class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

        if (url.contains("success-url")) 
        {
           //call intent to navigate to activity
            setResult(RESULT_OK, bundle);
            ActivityWebview.this.finish();
        }
    }

}