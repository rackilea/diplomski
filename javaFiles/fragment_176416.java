**myWebView.setWebViewClient(new MyWebViewClient());**
    myWebView.loadUrl("https://www.mijnmedicijn.nl");
   }

 private class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
  }  
}