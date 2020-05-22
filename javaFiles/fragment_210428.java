WebView browser = new WebView();
    browser.getEngine().getLoadWorker()
            .stateProperty()
            .addListener((obs, old, neww) ->
            {
                if (neww == Worker.State.SUCCEEDED)
                {
                    JSObject jsobj = (JSObject) browser.getEngine()
                            .executeScript("window");
                    jsobj.setMember("adder", new Adder());
                }
            });