...
private BorderPane root;
private HBox top;
private Text total;
private FlowPane target;

public EventHandler<MouseEvent> fieldClicked = (MouseEvent e) -> {
    ObservableList<Node> dices = target.getChildren();
    /* Do some stuff with fields */
};

private void initializeNodes() {
    ...
    total = new Text();
    top = new HBox(total);
    root.setTop(top);
    target = new FlowPane();
    root.setCenter(target);
    ...
}