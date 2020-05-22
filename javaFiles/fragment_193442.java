TextView textview1;

public void onCreate(Bundle savedInstanceState) {

    /* Your code here */

    textview1 = (TextView) findViewById(R.id.TextView1);

    WebView web = (WebView) view.findViewById(R.id.my_web);
    web.getSettings().setJavaScriptEnabled(true);
    web.addJavascriptInterface(new CustomJavaScriptInterface(), "JavaScriptInterface");
    web.setWebViewClient(new CustomWebViewClient());
    web.loadUrl("http://time.gov/HTML5/");

    /* Your code here */
}