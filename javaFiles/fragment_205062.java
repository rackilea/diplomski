enter code public class WebViewActivity extends AppCompatActivity {
private WebView mWebView;
private static final String urlTag = "url";

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    Intent intent = getIntent();
    String postUrl = intent.getStringExtra(urlTag);
    String title=intent.getStringExtra("title");
    mWebView = new WebView(this);
    mWebView.getSettings().setJavaScriptEnabled(true);

    final Activity activity = this;

    mWebView.setWebViewClient(new WebViewClient() {
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
        }
    });

    mWebView.loadUrl(postUrl);
    // setContentView(mWebView);

    // TODO:YUKLEME PROGRESS DENE
   mWebView.setWebViewClient(new WebViewClient() {
        ProgressDialog progressDialog = new ProgressDialog(WebViewActivity.this);

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.e("I am  loading Here ", "Start");
            progressDialog.setTitle("Loading");
            progressDialog.setMessage("Please wait....");
            progressDialog.show();

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.e("I am  loading Here ", "Override");
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressDialog.dismiss();
        }

    });
    setContentView(mWebView);
}