@Override
public boolean shouldOverrideUrlLoading (WebView view, String url) {
    Log.d("Loading webview", url);
    if (url.contains(TwitterActivity.CALLBACK_URL)) {
        Uri uri = Uri.parse(url);
        String oauthVerifier = uri.getQueryParameter("oauth_verifier");
        _twitterActivty.closeTwitterBrowser(oauthVerifier);
        return false;
    }
    view.loadUrl(url);
    return true;
}