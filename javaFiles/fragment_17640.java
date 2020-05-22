class RuleBox extends FlowPane {
    int maxWrapLength;
    int margin = 30;

    RuleBox(int maxWrapLength) {
        super();
        this.maxWrapLength = maxWrapLength;
        getChildren().addListener((ListChangeListener<? super Node>) observable -> actualizeWrapLength(observable.getList()));
    }

    private void actualizeWrapLength(ObservableList<? extends Node> list) {
        new Thread(() -> {
            try { Thread.sleep(50);
            } catch (InterruptedException ignored) {}
            Platform.runLater(() -> {
                int totalWidth = 0;
                for(Node n : list) {
                    if(n instanceof Control) totalWidth+=((Control)n).getWidth();
                    else if(n instanceof Region) totalWidth+=((Region)n).getWidth();
                }
                if(totalWidth+margin>maxWrapLength) setPrefWrapLength(maxWrapLength);
                else setPrefWrapLength(totalWidth+margin);
            });
        }).start();
    }

    void actualizeWrapLength() {
        actualizeWrapLength(getChildren());
    }
}