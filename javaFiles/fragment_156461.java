CefMessageRouter msgRouter = CefMessageRouter.create();
msgRouter.addHandler(new MessageRouterHandler(), true);
cefClient.addMessageRouter(msgRouter);
...
browser.executeJavaScript("cefQuery('Hello World')");
...
class MessageRouterHandler extends CefMessageRouterHandlerAdapter {
    @Override
    public boolean onQuery(CefBrowser browser, long query_id, String request, boolean persistent, CefQueryCallback callback) {
        System.out.println(request); // prints "Hello World"
    }
}