public class MainActivity extends Activity {

    private WebView mWebView;
    private boolean isVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient()); // for alert, anyway.

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String htmlString = "<html><div class=\"myClass\">\n" +
                "myClass text here" +
                "  <div class=\"innerClass\">\n" +
                "     Some Text here.\n" +
                "  </div>\n" +
                "</div>" +
                "</html>";

        mWebView.loadData(htmlString, "text/html; charset=utf-8", null);

        mWebView.loadUrl("javascript:alert('hello world')");
    }

    public void toggle(View view) {
        if (isVisible) {
            mWebView.loadUrl("javascript:var d = document.getElementsByClassName('innerClass')[0]; d.setAttribute(\"style\",\"display:none;\");");
        } else {
            mWebView.loadUrl("javascript:var d = document.getElementsByClassName('innerClass')[0]; d.setAttribute(\"style\",\"display:visible;\");");
        }
        isVisible = !isVisible;
    }
}