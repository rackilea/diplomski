public boolean onBackPressed() {
    if (webView != null && webView.canGoBack()) {
        webView.goBack();
        return true;
    }
    return false;
}