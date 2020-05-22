public void webView(){
        WebView webview = view.findViewById(R.id.service_webview);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webview.loadUrl("https://www.HIDDENURL.com/book/choose-service");
    }