@FXML
private WebView view;

private String link = "http://google.com";

private WebEngine engine;

@Override
public void initialize(URL url, ResourceBundle rb) {
    engine = view.getEngine();
    engine.load(link);
}