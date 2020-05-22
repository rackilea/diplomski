private WebView webView;
@Override
protected void onCreate(Bundle savedInstanceState){
      // ...
      this.webView = (WebView) findViewById(R.id.webView);
      // ...
}

@Override
public void onBackPressed(){
    // now you don't need findViewById because you can access field prepared in onCreate
    if (webView.canGoBack()) {
        webView.goBack();
    } else {
        super.onBackPressed();
    }
}