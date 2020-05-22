public class ActivityWebview extends Activity {

    final private String TAG = ActivityWebview.class.getSimpleName();
    private WebView wv;
    private AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        aq = new AQuery(this);
        wv = aq.id(R.id.wv).getWebView();
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.loadUrl("http://www.cnn.com");
    }
}