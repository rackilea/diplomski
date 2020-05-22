private void setUpWebView() {
        setWebviewSettings();
        mwebView.clearHistory();
        mwebView.clearFormData();
        mwebView.clearCache(false);
        mwebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mwebView.setScrollbarFadingEnabled(true);
        mwebView.getSettings().setSupportZoom(true);
        mwebView.setWebChromeClient(new CustomWebChromeClient(this));
        mwebView.setWebViewClient(new WebViewClient());
        mwebView.getSettings().setJavaScriptEnabled(true);
        mwebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        String url = AppConstants.FULL_TANDC_URL;
        if (NetworkUtil.isNetworkAvailable(this)) {
            if (url != null && !TextUtils.isEmpty(url) && URLUtil.isValidUrl(url)) {
                textNoData.setVisibility(View.GONE);
                if (url.contains(".pdf")) {
                    mwebView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + url);
                    mprogressBar.setVisibility(View.GONE);
                } else {
                    mwebView.loadUrl(url);
                    mprogressBar.setVisibility(View.VISIBLE);
                }
            } else {
                textNoData.setVisibility(View.VISIBLE);
                mprogressBar.setVisibility(View.GONE);
            }
        } else {
            mprogressBar.setVisibility(View.GONE);
            textNoData.setVisibility(View.VISIBLE);
        }

    }