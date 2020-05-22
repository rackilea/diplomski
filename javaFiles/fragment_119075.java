public static class WebViewJavaScriptInterface {
    private WebInterfaceDelegate delegate;

    public WebViewJavaScriptInterface(WebInterfaceDelegate delegate) {
        this.delegate = delegate;
    }

    public void htmlLoaded(String html) {
        if (delegate != null) {
            delegate.receivedHtml(html);
        }
    }
}