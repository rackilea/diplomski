@Override
protected void onCreate(Bundle savedInstanceState) {


    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        wv = (WebView) findViewById(R.id.myWeb);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wv.getSettings().setDomStorageEnabled(true);
        wv.setWebViewClient(new MyWebViewClient());
        wv.setWebChromeClient(new MyWebChromeClient());


        if (savedInstanceState == null)
        {
           wv.loadUrl("http://www.mmcloudschooling.com");
        } else {
           wv.restoreState(savedInstanceState);

        }


}

@Override
protected void onSaveInstanceState(Bundle outState )
{
    super.onSaveInstanceState(outState);
    wv.saveState(outState);
}

@Override
protected void onRestoreInstanceState(Bundle savedInstanceState)
{
    super.onRestoreInstanceState(savedInstanceState);
    wv.restoreState(savedInstanceState);
}