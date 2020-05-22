public void setWebView() {
//WebViewClient is used if you want to capture stuff from the webview, like if a link was pressed
                WebViewClient yourWebClient = new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        open_web = true;
                        if (!url.startsWith("http://") && !url.startsWith("https://")) {
                                url = "http://" + url;
                        }
                        Intent browserIntent = new Intent("android.intent.action.VIEW",
                                Uri.parse(url));
                        startActivity(browserIntent);
                        return true;
                    }
                };
                WebView wv = (WebView) findViewById(R.id.webview);
                wv.setWebViewClient(yourWebClient);
                String str = getHtml();
                wv.loadData(str, "text/html", "utf-8");
                wv.setBackgroundColor(0);
    }

    boolean isAsset = false;

    private String getHtml(){
        InputStream source = null;
        if (isAsset){
            source = getAssets().open("motd.html");
        } else {
            source = new FileInputStream(Environment.getExternalStorageDirectory() + "motd.html");
        }
    }