private class MyWebViewClient extends WebViewClient {

    private Context context;

    public MyWebViewClient(Context context) {
        this.context = context;

    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if (url.equals("http://aaa.freeasphost.net/MainPanel.aspx")) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            context.startActivity(intent);
            return false;
        } else {

            return true;
        }
}