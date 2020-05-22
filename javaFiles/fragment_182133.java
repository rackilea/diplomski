webview.loadData(st, "text/html", "UTF-8");

 public class CustomWebViewClient extends WebViewClient
     {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
          if(request.getUrl().toString().contains("about:blank"))
              return true;
          if (view.getHitTestResult().getType() > 0) {
              view.getContext().startActivity(
                      new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(request.getUrl()))));
              return true;
          } else {
              return false;
          }
      }
      public boolean shouldOverrideUrlLoading(WebView view, String request) {
          if(request.contains("about:blank"))
              return true;
          if (view.getHitTestResult().getType() > 0) {
              view.getContext().startActivity(
                      new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(request))));
              return true;
          } else {
              return false;
          }
      }
  }