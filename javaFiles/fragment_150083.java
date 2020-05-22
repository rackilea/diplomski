myWebView.setWebViewClient(new WebViewClient(){
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            String url2="http://www.example.com/";
            // all links  with in your site will be open inside the webview
            //links that start your domain, for example (http://www.example.com/)
            if (url != null && url.startsWith(url2)){
                return false;
            }
            // all links that points outside the site will be open in a normal android browser
            else  {
                view.getContext().startActivity(
                        new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                return true;
            }
        }
    });