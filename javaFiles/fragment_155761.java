public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    EditText editText;
    WebView webView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.but);
        button2 = (Button)findViewById(R.id.but1);
        editText = (EditText)findViewById(R.id.edittext);
        webView = (WebView)findViewById(R.id.webView);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url=editText.getText().toString();
                url="http://"+url;
                loadUrl(url);
            }
        });
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               url="http://www.stackoverflow.com";
               loadUrl(url);
           }
       });

    }

    public void loadUrl(String url) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setVisibility(View.VISIBLE);
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        }
}