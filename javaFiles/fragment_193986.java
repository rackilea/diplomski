@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
    if (url.equals("example.com") || url.equals("http://example.com")) {
        url = url + "?mode=app";
    }
    view.loadUrl(url);
    return true;
}