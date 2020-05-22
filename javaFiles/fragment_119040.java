WebView mWebView= (WebView) findViewById(R.id.webView1);
mWebView.setWebViewClient(new WebViewClient() {
        @Override
        public void onReceivedError(WebView view, int errorCode,
                String description, String failingUrl) {
            // Handle the error
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    });

mWebView.loadUrl("http://google.com");