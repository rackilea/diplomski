public class JavaScriptBridge {
    public void callback(String data) {
        System.out.println("callback retrieved: " + data);
    }
}

private JavaScriptBridge bridge;

@Override
public void start(Stage primaryStage) throws Exception {
    WebView webView = new WebView();
    primaryStage.setScene(new Scene(new AnchorPane(webView)));
    primaryStage.show();

    final WebEngine webEngine = webView.getEngine();
    webEngine.load(getClass().getClassLoader().getResource("page.html").toExternalForm());

    bridge = new JavaScriptBridge();
    webEngine.getLoadWorker().stateProperty().addListener((observableValue, oldValue, newValue) -> {
        if (newValue == State.SUCCEEDED) {
            JSObject window = (JSObject) webEngine.executeScript("window");
            window.setMember("javaApp", bridge);
        }
    });

    webEngine.setOnAlert(event -> {
        System.out.println(DATE_FORMAT.format(new Date()) + " alerted: " + event.getData());
    });
}