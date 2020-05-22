public class AppController {
    public WebView webview;

    @FXML
    public void initialize() {
        final Console console = new Console();
        final WebEngine engine = webview.getEngine();
        engine.setJavaScriptEnabled(true);
        engine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                final JSObject window = (JSObject) engine.executeScript("window");
                window.setMember("console", console);
            }
        });
    }

    public class Console {
        public void log(String text) {
            System.out.println("[WebView console] " + text);
        }
    }
}