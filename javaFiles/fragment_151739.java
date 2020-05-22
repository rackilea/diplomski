Pane pane ;

// ...

Task<ResultType> computation = ... ;

pane.disableProperty().bind(computation.runningProperty());
new Thread(computation).start();