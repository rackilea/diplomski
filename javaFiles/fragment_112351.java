webView.getSettings().setJavaScriptEnabled(true);
MyJavaScriptInterface jInterface = new MyJavaScriptInterface(context);
webView.addJavascriptInterface(jInterface, "HtmlViewer");

webView.setWebViewClient(new WebViewClient() {

@Override
public void onPageFinished(WebView view, String url) {

   //Load HTML
   webView.loadUrl("javascript:window.HtmlViewer.showHTML
       ('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
}

webView.loadUrl(StartURL);
ParseHtml(jInterface.html);   

public class MyJavaScriptInterface {

    private Context ctx;
    public String html;

    MyJavaScriptInterface(Context ctx) {
        this.ctx = ctx;
    }

    @JavascriptInterface
    public void showHTML(String _html) {
        html = _html;
    }
}