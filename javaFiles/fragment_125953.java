webview.setWebViewClient(new WebViewClient()
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

            //Here check whether the url is after logged in
            if(url.equals("URL after user logged In")){
                //start new activity
          }

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.d("WebView", "your current url when webpage loading.. finish" + url);
            super.onPageFinished(view, url);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onLoadResource(view, url);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            System.out.println("when you click on any interlink on webview that time you got url :-" + url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    });