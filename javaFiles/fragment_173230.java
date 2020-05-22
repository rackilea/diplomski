public void getVideoPath(String path) {
        if (progressDialog == null) {
                // in standard case YourActivity.this
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
            }
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            webView.setScrollbarFadingEnabled(false);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.addJavascriptInterface(new MyJavaScriptInterface(), "HTMLOUT");
            webView.setWebViewClient(new WebViewClient() {


                //If you will not use this method url links are opeen in new brower not in webview
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                //Show loader on url load
                public void onLoadResource(WebView view, String url) {

                }

                public void onPageFinished(WebView view, String url) {
                    try {
                        webView.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }

            });
            webView.loadUrl(path);

        }

        class MyJavaScriptInterface {
            @JavascriptInterface
            @SuppressWarnings("unused")
            public void processHTML(String html) {

                int start = html.indexOf("class=\"player-video\" src=\"");
                int end = html.indexOf("\" preload=\"metadata\"");
                String finalUrl = html.substring((start + 26), (end));
                playUrl(finalUrl);
            }

        }
try it.