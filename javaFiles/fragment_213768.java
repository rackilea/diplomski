webview.getSettings().setJavaScriptEnabled(true);
    webview.setWebChromeClient(new WebChromeClient() {
        public void onProgressChanged(WebView view, final int progress) {
            progressBar.setProgress(progress);
            if (progress == 100) {
                grabScreen();
            } 
        }
    });