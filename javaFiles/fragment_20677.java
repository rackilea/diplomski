public class MyActivity extends Activity implements AdvancedWebView.Listener {

private AdvancedWebView mWebView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);

    mWebView = (AdvancedWebView) findViewById(R.id.webview);
    mWebView.setListener(this, this);
    mWebView.loadUrl("http://www.example.org/");

    // ...
}

@SuppressLint("NewApi")
@Override
protected void onResume() {
    super.onResume();
    mWebView.onResume();
    // ...
}

@SuppressLint("NewApi")
@Override
protected void onPause() {
    mWebView.onPause();
    // ...
    super.onPause();
}

@Override
protected void onDestroy() {
    mWebView.onDestroy();
    // ...
    super.onDestroy();
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    mWebView.onActivityResult(requestCode, resultCode, intent);
    // ...
}

@Override
public void onBackPressed() {
    if (!mWebView.onBackPressed()) { return; }
    // ...
    super.onBackPressed();
}

@Override
public void onPageStarted(String url, Bitmap favicon) { }

@Override
public void onPageFinished(String url) { }

@Override
public void onPageError(int errorCode, String description, String failingUrl) { }

@Override
public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) { }

@Override
public void onExternalPageRequest(String url) { }

}