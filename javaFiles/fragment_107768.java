private WebView WebDimrah;
private WebSettings WebSettingDimrah;

@SuppressLint("SetJavaScriptEnabled")
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);


WebDimrah  = (WebView)findViewById(R.id.WebView1);
WebSettingDimrah  = WebDimrah.getSettings() ;
WebDimrah.getSettings().setJavaScriptEnabled(true);

WebDimrah.setWebViewClient(new WebViewClient() {
@Override
public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {

handler.proceed();

      }
   });
 WebDimrah.loadUrl("https://facebook.com");

}