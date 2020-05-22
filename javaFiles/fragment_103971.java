public WebView geturl(String url){
    WebView webView = new WebView();
    webView.getEngine().load(url);
    return webView;
}

public void initfx(JFXPanel panel){
    WebView webView = geturl(FirstToken.finallink);
    Scene scene = createscene(webView);
    panel.setScene(scene);
}

public Scene createscene(WebView webView){
    Pane root = new Pane();
    Scene scene = new Scene(root);
    root.getChildren().add(webView);

    return scene;
}