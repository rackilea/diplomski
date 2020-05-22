public class MyWebViewClient extends WebViewClient {

public MyWebViewClient() {
  super();
  //start anything you need to
}

public void onPageStarted(WebView view, String url, Bitmap favicon) {
  //Do something to the urls, views, etc.
 }
}