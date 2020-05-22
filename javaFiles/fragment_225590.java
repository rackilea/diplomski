WebSettings settings = webView.getSettings();
settings.setJavaScriptEnabled(true);
settings.setAllowContentAccess(true);
settings.setDomStorageEnabled(true);
webView.setWebViewClient(new WebViewClient());
webView.loadUrl("https://vk.com/zabroshkiborika");