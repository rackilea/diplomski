WebEngine webEngine = browser.getEngine();

    webEngine.getLoadWorker().stateProperty().addListener((ov,oldState,newState)->{
        if(newState==State.SUCCEEDED){
            JSObject window = (JSObject) webEngine.executeScript("window");
            window.setMember("app", new JavaApplication());
        }
    });
    webView.getEngine().loadContent("<html>\n"
            + " <script>function initialize() {"
            + " var lengthInMeters = 5; " 
            + " app.calljavascript(lengthInMeters);"
            + "} </script> "
            + "    <body onLoad=\"initialize()\">Hi!\n"
            + "    </body>\n"
            + "</html>");