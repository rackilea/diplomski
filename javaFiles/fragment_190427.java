webView.setWebViewClient(new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 

            try {

            // do whatever you want to do on a web link click

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

    });