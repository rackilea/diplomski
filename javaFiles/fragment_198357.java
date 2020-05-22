EventHandler<ActionEvent> handler = event -> {
    // get button that triggered the action
    Node n = (Node) event.getSource();

    // get node to remove
    Node p = n.getParent();

    // remove p from parent's child list
    ((Pane) p.getParent()).getChildren().remove(p);
};
Button button = new Button("x");
button.setOnAction(handler);