@Override
public void onBackPressed() {
    WebView webView = (WebView) findViewById(R.id.webview);
    if (webView.canGoBack()) {
        webView.goBack();
    } else {
        super.onBackPressed();
    }
}