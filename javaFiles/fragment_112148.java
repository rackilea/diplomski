WebView webView = new WebView();
WebEngine engine = webView.getEngine();
engine.load("path/to/index.html");

// Assuming that somewhere in 'index.html', the loading of "module/logger" is triggered...

{ ... let some time pass ...} // 

final JSObject loggerModule = (JSObject) engine.executeScript(
    "require('module/logger')"
);
logger.call("trace", "hello world!");