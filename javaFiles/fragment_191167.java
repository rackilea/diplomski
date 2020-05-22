@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_testing);

    WebView webView = (WebView)findViewById(R.id.webView1);


    webView.getSettings().setJavaScriptEnabled(true);
    webView.addJavascriptInterface(new WebViewJavaScriptInterface(this), "Android");
    webView.addJavascriptInterface(new userDetail("arun",24), "HtmlViewer");
    webView.loadUrl("file:///android_asset/yourhtml.html");
}

public class WebViewJavaScriptInterface{

    private Context context;


    public WebViewJavaScriptInterface(Context context){
        this.context = context;
    }

    @JavascriptInterface
    public void showMessage(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}