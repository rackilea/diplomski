private class CustomWebViewClient extends WebViewClient {
    @Override
    public void onPageFinished(WebView view, String url) {
        //Inject the HTML in to the JavaScriptInterface
        view.loadUrl("javascript:window.JavaScriptInterface.html('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
    }
}