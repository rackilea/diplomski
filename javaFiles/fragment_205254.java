webView.setWebViewClient(new WebViewClient(){
// Api < 24
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && url.endsWith(".html")) {
                    view.loadUrl(url);
                    return true;
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
                    return true;
                }
            }
// Api > 24
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (request.getUrl().toString() != null && request.getUrl().toString().endsWith(".html")) {
                    view.loadUrl(request.getUrl().toString());
                    return true;
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW,request.getUrl()));
                    return true;
                }
            }
        });
        webView.loadUrl("https://google.com");