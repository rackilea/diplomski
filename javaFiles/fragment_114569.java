private WebView myWebView; // Move this declaration out from onCreate()

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    myWebView = (WebView) findViewById(R.id.webview);

    // rest of the method...
}

@Override
public void onPause() {
    super.onPause();
    myWebView.pauseTimers();
}