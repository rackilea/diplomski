public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            view.loadUrl("javascript:(function() { " +
                    "var element = document.getElementById('mainHeader');"
                    + "element.parentNode.removeChild(element);" +
                    "var element = document.getElementById('footerRights');"+ "element.parentNode.removeChild(element);" + "})()");

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

        }


    }