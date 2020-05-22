final HashMap<String, WebSocketNew> ws = new HashMap<>();
    //runs on non-UI-thread
    class WebSocketFactory
    {
        public WebSocketFactory()
        {
        }

        @JavascriptInterface
        public WebSocketNew getInstance(String url)
        {
            System.out.println("============WebSocketFactory============getInstance  " + url);

            try
            {
                ws.put(url, new WebSocketNew(new URI(url)));
                ws.get(url).connect();

                System.out.println("=====WebSocketNew=====" + url + "  " + ws.get(url).getReadyState());

                return ws.get(url);
            }
            catch (Exception e)
            {
                System.out.println("==========ERROR");
                return null;
            }
        }
    }

    wv.addJavascriptInterface(new WebSocketFactory(), "factoryJ");

    wv.loadUrl("file:///android_asset/Content/app.html");