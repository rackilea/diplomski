public class WebViewTestActivity extends Activity implements
        View.OnClickListener {
    /** Called when the activity is first created. */
    Button btn = null;
    WebView myWebView =null;
    EditText et =null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(this);
        et = (EditText) findViewById(R.id.editText1);
        myWebView = (WebView) findViewById(R.id.webview);
// WebViewClient in use.
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                et.setText(url);
            }
        });
    }

    @Override
    public void onClick(View source) {
        if (btn.getText().equals("Go!")) {
            myWebView.loadUrl(et.getText().toString());
        }
    }

}