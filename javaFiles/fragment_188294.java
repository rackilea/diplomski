wv.getSettings().setJavaScriptEnabled(true); // enable javascript

final Activity activity = this;

 wv.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
                }
            });

wv.loadUrl("http://www.google.com");