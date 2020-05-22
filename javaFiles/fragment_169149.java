WebEngine webEngine = browser.getEngine();
    JSObject window = (JSObject) webEngine.executeScript("window");
    window.setMember("app", new JavaApplication());

    browser.getEngine().loadContent("<html>\n"
            + " <script>function initialize() {"
            + " var lengthInMeters = 5; " 
            + " app.calljavascript(lengthInMeters);"
            + "} </script> "
            + "    <body onLoad=\"initialize()\">Hi!\n"
            + "    </body>\n"
            + "</html>");