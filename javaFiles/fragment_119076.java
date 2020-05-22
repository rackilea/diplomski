public class AndroidWebViewActivity extends Activity implements WebInterfaceDelegate {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //...
        WebView webView = (WebView)findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebViewJavaScriptInterface(this), "AndroidAPI");

        webView.loadUrl("http://your.url.com");
    }

    //...

    public void receivedHtml(String html) {
        //inspect the HTML here
        System.out.println("Got html:  " + html);
    }
}