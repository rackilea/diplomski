//Create Layout + WebView
AnchorPane anchorPane = new AnchorPane();
WebView webView = new WebView();

//Set Layout Constraint
AnchorPane.setTopAnchor(webView, 0.0);
AnchorPane.setBottomAnchor(webView, 0.0);
AnchorPane.setLeftAnchor(webView, 0.0);
AnchorPane.setRightAnchor(webView, 0.0);

//Add WebView to AnchorPane
anchorPane.getChildren().add(webView);

//Create Scene
final Scene scene = new Scene(anchorPane);

// Obtain the webEngine to navigate
WebEngine webEngine = webView.getEngine();
webEngine.load(url);