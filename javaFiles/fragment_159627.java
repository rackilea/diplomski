webView.setWebViewClient(new WebViewClient()
{
  @Override
  public boolean shouldOverrideUrlLoading(WebView view, String url)
  {
    // My own condition to decide if I should skip URL loading
    boolean avoidURLLoading = ...

    if (avoidURLLoading)
    {
      // Ask the WebView to avoid loading the URL,
      // I want to manage this case on my own.
      return true;
    }
    else
    {
      // Let the WebView load the URL 
      return false;
    }
  };
});