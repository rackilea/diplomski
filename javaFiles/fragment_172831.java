public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.document_viewer_activity);

    WebView wv = (WebView) findViewById(R.id.documentViewerWebview);
    wv.getSettings().setJavaScriptEnabled(true);

    String url = getString(R.string.document_viewer_url) + 
            getIntent().getExtras().getString("media");
    wv.loadUrl(url);

}