WebView wv;
Handler uiHandler = new Handler();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    wv = (WebView)findViewById(R.id.webView);
    wv.setWebViewClient(new MyWebViewClient());

    new BackgroundWorker().execute();

}

// load links in WebView instead of default browser
private class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return false;
    }

    @RequiresApi(21)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(request.getUrl().toString());
        return false;
    }
}

private class BackgroundWorker extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... arg0) {
        getDarewod();
        return null;
    }

    public void getDarewod(){

        try {
            Document htmlDocument = Jsoup.connect("http://darebee.com/").get();
            Element element = htmlDocument.select("#gkHeaderMod > div.darewod").first();

            // replace body with selected element
            htmlDocument.body().empty().append(element.toString());
            final String html = htmlDocument.toString();

            uiHandler.post(new Runnable() {
                @Override
                public void run() {
                    wv.loadData(html, "text/html", "UTF-8");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}