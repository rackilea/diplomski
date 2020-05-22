webView.setWebViewClient(new WebViewClient() {
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progess.setVisibility(View.VISIBLE);
        }
        public void onPageFinished(WebView view, String url) {
        progess.setVisibility(View.GONE);
        }