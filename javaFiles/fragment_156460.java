cefClient.addLoadHandler(new LoadHandler());
...
class LoadHandler extends CefLoadHandlerAdapter {
    @Override
    public void onLoadEnd(CefBrowser browser, int frameId, int status) {
        String jscode = "var x = document.getElementsByClassName('example')";
        browser.executeJavaScript(jscode);
    }
}