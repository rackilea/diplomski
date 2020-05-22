@Override
public void onBackPressed() {
    if (webView.canGoBack()) {
        webView.goBack();
        return;
    }
    // Otherwise defer to system default behavior.
    super.onBackPressed();
}