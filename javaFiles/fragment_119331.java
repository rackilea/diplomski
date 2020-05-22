public void installChangeColorHandler(Pane pane) {
    pane.setOnMouseClicked(event -> {
        for (Node child : pane.getChildren()) {
            if (child instanceof Rectangle 
                    && child.contains(child.parentToLocal(event.getX(), event.getY()))) {
                ((Rectangle) child).setFill(/* YOUR COLOR */);
                event.consume();
                break;
            }
        }
    });
}