public class Webview extends Activity{

private WebView wv;
private String url;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.webview);

    // get the url to open
    Intent intentBundle = this.getIntent();
    url = intentBundle.getStringExtra("url");

    wv = (WebView) findViewById(R.id.myWebView);
    wv.setWebViewClient(new WebViewClient()); // needed to open url inside our webview, otherwise it will open at the default browser
    wv.loadUrl(url);
}}