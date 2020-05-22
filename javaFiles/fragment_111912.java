public class MainActivity extends Activity {

WebView wv;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    wv= (WebView) findViewById(R.id.wv);
    wv.getSettings().setPluginsEnabled(true);
    WebSettings webSettings = wv.getSettings();
    webSettings.setJavaScriptEnabled(true);
    wv.getSettings().setDomStorageEnabled(true);

    wv.setWebViewClient(new MyOwnWebViewClient());
    wv.loadUrl("http://surveyanyplace.com/s/pozitiemers/");
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}
class MyOwnWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl("http://surveyanyplace.com/s/pozitiemers/");
        return true;
    }
 }