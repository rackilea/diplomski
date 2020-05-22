public class Webview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);; 
        String webLink = getIntent().getStringExtra("weblink");
        WebView wv;  
        wv = (WebView) findViewById(R.id.webview);  
        wv.loadUrl(webLink);

    }