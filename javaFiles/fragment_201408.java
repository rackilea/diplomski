public class MainActivity extends AppCompatActivity {


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    WebView myWebView = findViewById(R.id.webview);
    myWebView.loadUrl("http://www.google.com");
    myWebView.addJavascriptInterface(new WebAppInterface(), "Android");
}

public void myMethod(String test){
    Toast.makeText(this, test, Toast.LENGTH_SHORT).show();

}

public class WebAppInterface {

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        MainActivity.this.myMethod("Hello there");
    }
}

}