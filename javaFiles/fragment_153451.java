public void onBackPressed() {
    if (webview.canGoBack())
        webview.goBack();
    else
        super.onBackPressed();
}