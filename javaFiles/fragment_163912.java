private Point2D pLimit;
private double width, height;

@Override
public void start(Stage primaryStage) {
    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();

    // disable context menu (copy option)
    webView.setContextMenuEnabled(false);

    WebEventDispatcher webEventDispatcher = new WebEventDispatcher(webView.getEventDispatcher());
    webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {

        @Override
        public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
            if(newValue.equals(State.SUCCEEDED)){
                // dispatch all events
                webView.setEventDispatcher(webEventDispatcher);
            }
        }

    });
    webEngine.load("<URL>");

    Scene scene = new Scene(webView);

    primaryStage.setTitle("WebView scrollbar test");
    primaryStage.setScene(scene);
    primaryStage.show();

    webView.getChildrenUnmodifiable().addListener(new ListChangeListener<Node>() {

        @Override
        public void onChanged(Change<? extends Node> c) {
            pLimit=webView.localToScene(webView.getWidth(),webView.getHeight());
            webView.lookupAll(".scroll-bar").stream()
                    .map(s->(ScrollBar)s).forEach(s->{
                        if(s.getOrientation().equals(VERTICAL)){
                            width=s.getBoundsInLocal().getWidth();
                        }
                        if(s.getOrientation().equals(HORIZONTAL)){
                            height=s.getBoundsInLocal().getHeight();
                        }
                    });
            // dispatch all events
            webEventDispatcher.setLimit(pLimit.subtract(width, height));
        }
    });

}