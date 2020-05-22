protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    WebView myWebView = (WebView) findViewById(R.id.webview);
    //myWebView.setWebViewClient(new WebViewClient());
    // Enable Javascript
    // Let's display the progress in the activity title bar, like the
    // browser app does.
    requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    requestWindowFeature(Window.FEATURE_PROGRESS);

    //setContentView(R.layout.webview);

    setProgressBarIndeterminateVisibility(true);
    setProgressBarVisibility(true);

    try {
        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new browserActivityClient());
        myWebView.getSettings().setBuiltInZoomControls(true);

        myWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
                if (progress == 100) {
                    setProgressBarIndeterminateVisibility(false);
                    setProgressBarVisibility(false);
                }
            }
        });
        myWebView.loadUrl("http://www.jtube.live/Tube_app");
    } catch (Exception e) {
        Log.e(getClass().getSimpleName(), "Browser: " + e.getMessage());
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }
}

/**
 * add class 
 */
class browserActivityClient extends WebViewClient {
    ...
}